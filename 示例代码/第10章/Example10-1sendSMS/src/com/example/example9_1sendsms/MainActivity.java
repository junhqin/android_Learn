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
        //��ť
        button=(Button)findViewById(R.id.button);
        //�绰����
        etTel=(EditText)findViewById(R.id.etext);
        //���������
        etContent=(EditText)findViewById(R.id.edittext);
        button.setOnClickListener
        (
        	new OnClickListener()
        	{
				public void onClick(View v)
				{
			        String strTel=etTel.getText().toString();
			        String strContent =etContent.getText().toString();
					//������Ҫ�жϵ绰�����Ƿ���ϸ�ʽ
					if(PhoneNumberUtils.isGlobalPhoneNumber(strTel))
					{
						button.setEnabled(false);
						sendSMS(strTel,strContent,v);
					}
					else
					{
						Toast.makeText(MainActivity.this, "������ĵ绰���벻���ϸ�ʽ��", Toast.LENGTH_SHORT).show();
					}
				}
        	}
        );
    } 
    //�Զ���ķ�����Ϣ�ķ���   
    public void sendSMS(String telephoneNo,String smsContent,View v)
    {
    	PendingIntent pIntent=PendingIntent.getActivity(this, 0, new Intent(this,MainActivity.class), 0);
    	SmsManager sms=SmsManager.getDefault();
    	sms.sendTextMessage(telephoneNo, null, smsContent, pIntent, null);
    	//���ŷ��ͳɹ�������ʾ
    	Toast.makeText(MainActivity.this,"��ϲ�����ŷ��ͳɹ���",Toast.LENGTH_LONG).show(); 
    	v.setEnabled(true);
    }

	}