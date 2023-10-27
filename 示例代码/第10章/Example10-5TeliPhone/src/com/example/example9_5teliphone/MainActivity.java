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

	//获得0-9按钮的id
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
	        //删除按钮
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
	        //播出按钮 
	        Button bcButton=(Button)findViewById(R.id.Button_dial);
	        bcButton.setOnClickListener
	        (
	        	new OnClickListener()
	        	{
					@Override
					public void onClick(View v)
					{
						 //获取输入的电话号码
		               	 EditText et=(EditText)findViewById(R.id.EditText01);
		               	 String tempStr=et.getText().toString();
		               	 if(PhoneNumberUtils.isGlobalPhoneNumber(tempStr))
		               	 {
		               		 //根据获取的电话号码创建Intent拨号
			               	 Intent dial = new Intent();
			                 dial.setAction("android.intent.action.CALL");
			                 dial.setData(Uri.parse("tel://"+tempStr));
			                 startActivity(dial);
		               	 }
		               	 else
		               	 {
		               		 Toast.makeText(MainActivity.this, "电话号码格式不符合要求", Toast.LENGTH_SHORT).show();
		               	 }
					}
	        	}
	        );
	        //挂断按钮
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
	        //为0-9数字按钮创建监听器
	        View.OnClickListener numListener=new  View.OnClickListener()
	        {
	        	public void onClick(View v) 
	            { 
		        	  Button tempb=(Button)v;
		        	  EditText et=(EditText)findViewById(R.id.EditText01);
		        	  et.append(tempb.getText());
	            }
	        };
	        
	        //为所有数字按钮添加监听器
	        for(int id:numId)
	        {
	        	Button tempb=(Button)this.findViewById(id);
	        	tempb.setOnClickListener(numListener);
	        }
	    }
}
