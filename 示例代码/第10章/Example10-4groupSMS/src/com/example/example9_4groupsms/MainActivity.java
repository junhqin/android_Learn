package com.example.example9_4groupsms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText smsContent;
	EditText person;
	HashMap<String,String> peoples=new HashMap<String,String>();
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsContent=(EditText)findViewById(R.id.et0);
        person=(EditText)findViewById(R.id.et1);
        //添加联系人按钮
        Button selectButton=(Button)findViewById(R.id.button0);
        selectButton.setOnClickListener
        (
        	new OnClickListener()
        	{
				@Override
				public void onClick(View v)
				{
					Uri uri=Uri.parse("content://contacts/people");
					Intent intent=new Intent(Intent.ACTION_PICK,uri);
					startActivityForResult(intent,1);
				}
        	}
        );
        //发送信息按钮
        Button sendButton=(Button)findViewById(R.id.button1);
        sendButton.setOnClickListener
        (
        	new OnClickListener()
        	{
				@Override
				public void onClick(View v)
				{
					v.setEnabled(false);
					EditText etSms=(EditText)findViewById(R.id.et1);
					String smsStr=etSms.getText().toString();
					Set<String> keySet=peoples.keySet();
					Iterator<String> ii=keySet.iterator();
					smsContent.setText("");
					person.setText("");
					while(ii.hasNext())
					{
						Object key=ii.next();
						String tempPhone=peoples.get(key);
						 if(PhoneNumberUtils.isGlobalPhoneNumber(tempPhone))
						 {
							 sendSMS(tempPhone,smsStr,v);
						 }
					}
				}
        	}
        );
        
    }
    //自定义的发送消息的方法   
    public void sendSMS(String telephoneNo,String smsContent,View v)
    {
    	PendingIntent pIntent=PendingIntent.getActivity(this, 0, new Intent(this,MainActivity.class), 0);
    	SmsManager sms=SmsManager.getDefault();
    	sms.sendTextMessage(telephoneNo, null, smsContent, pIntent, null);
    	//短信发送成功给予提示
    	Toast.makeText(MainActivity.this,"恭喜，短信发送成功！",Toast.LENGTH_SHORT).show(); 
    	v.setEnabled(true);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode==1)
    	{
    		Uri uri=data.getData();
    		if(uri!=null)
    		{
    			try
    			{
    				ContentResolver cResolver=this.getContentResolver();//获取ContentResolver对象
    				Cursor cursor=this.managedQuery(uri,null,null,null,null);
    				cursor.moveToFirst();								//移动到第一个位置
    				int nameFieldColumnIndex=cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
    				String sName=cursor.getString(nameFieldColumnIndex);//获取相应索引值对应的名字
    				String contactId=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
    				Cursor phone=cResolver.query						//获取数据
    				(
    					ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
    					null, 
    					ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+contactId,
    					null,
    					null
    				);
    				String strPhoneNumber="";
    				if(phone.moveToNext())
    				{
    					strPhoneNumber=phone.getString
				    					(
				    						phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
				    					);
    				}
    				peoples.put(sName, strPhoneNumber);
    				Set<String> keySet=peoples.keySet();
    				Iterator<String> ii=keySet.iterator();
    				person.setText("");
    				while(ii.hasNext())
    				{
    					Object key=ii.next();
    					String tempName=(String)key;
    					String tempPhone=peoples.get(key);
    					person.setText(person.getText()+tempName+":"+tempPhone+"\n");
    				}
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
    	}
    }
}
