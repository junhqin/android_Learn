package com.example.example9_1sendsms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	Button button;
	EditText etTel;
	EditText etContent; 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //按钮
        button=(Button)findViewById(R.id.button);
        //电话号码
        etTel=(EditText)findViewById(R.id.etext);
        //输入的内容
        etContent=(EditText)findViewById(R.id.edittext);
        button.setOnClickListener
        (
        	new OnClickListener()
        	{
				public void onClick(View v)
				{
			        String strTel=etTel.getText().toString();
			        String strContent =etContent.getText().toString();
					//首先需要判断电话号码是否符合格式
					if(PhoneNumberUtils.isGlobalPhoneNumber(strTel))
					{
						button.setEnabled(false);
						sendSMS(strTel,strContent,v);
					}
					else
					{
						Toast.makeText(MainActivity.this, "您输入的电话号码不符合格式！", Toast.LENGTH_SHORT).show();
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
    	Toast.makeText(MainActivity.this,"恭喜，短信发送成功！",Toast.LENGTH_LONG).show(); 
    	v.setEnabled(true);
    }

	}