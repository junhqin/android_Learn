package com.example.example9_5teliphone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends Activity {

	//���0-9��ť��id
		int[] numId=new int[]
		{
			R.id.Button00,R.id.Button01,
			R.id.Button02,R.id.Button03,
			R.id.Button04,R.id.Button05,
			R.id.Button06,R.id.Button07,
			R.id.Button08,R.id.Button09,
		};
	    @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.activity_main);
	        //ɾ����ť
	        Button delButton=(Button)findViewById(R.id.Button_del);
	        delButton.setOnClickListener
	        (
	        	new OnClickListener()
	        	{
					@Override
					public void onClick(View v)
					{
						EditText et=(EditText)findViewById(R.id.EditText01);
						String tempStr=et.getText().toString();
						tempStr=(tempStr.length()-1>=0)?tempStr.substring(0, tempStr.length()-1):"";
						et.setText(tempStr);
					}
	        	}
	        );
	        //������ť 
	        Button bcButton=(Button)findViewById(R.id.Button_dial);
	        bcButton.setOnClickListener
	        (
	        	new OnClickListener()
	        	{
					@Override
					public void onClick(View v)
					{
						 //��ȡ����ĵ绰����
		               	 EditText et=(EditText)findViewById(R.id.EditText01);
		               	 String tempStr=et.getText().toString();
		               	 if(PhoneNumberUtils.isGlobalPhoneNumber(tempStr))
		               	 {
		               		 //���ݻ�ȡ�ĵ绰���봴��Intent����
			               	 Intent dial = new Intent();
			                 dial.setAction("android.intent.action.CALL");
			                 dial.setData(Uri.parse("tel://"+tempStr));
			                 startActivity(dial);
		               	 }
		               	 else
		               	 {
		               		 Toast.makeText(MainActivity.this, "�绰�����ʽ������Ҫ��", Toast.LENGTH_SHORT).show();
		               	 }
					}
	        	}
	        );
	        //�Ҷϰ�ť
	        Button cancelButton=(Button)findViewById(R.id.Button_cancel);
	        cancelButton.setOnClickListener
	        (
	        	new OnClickListener()
	        	{
					@Override
					public void onClick(View v)
					{
						MainActivity.this.finish();
					}
	        	}
	        );
	        //Ϊ0-9���ְ�ť����������
	        View.OnClickListener numListener=new  View.OnClickListener()
	        {
	        	public void onClick(View v) 
	            { 
		        	  Button tempb=(Button)v;
		        	  EditText et=(EditText)findViewById(R.id.EditText01);
		        	  et.append(tempb.getText());
	            }
	        };
	        
	        //Ϊ�������ְ�ť��Ӽ�����
	        for(int id:numId)
	        {
	        	Button tempb=(Button)this.findViewById(id);
	        	tempb.setOnClickListener(numListener);
	        }
	    }
}
