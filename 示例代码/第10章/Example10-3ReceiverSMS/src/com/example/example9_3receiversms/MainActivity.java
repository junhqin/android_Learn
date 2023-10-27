package com.example.example9_3receiversms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView;  
    protected void onCreate(Bundle savedInstanceState) {  
        // TODO Auto-generated method stub  
        super.onCreate(savedInstanceState);  
          
        setContentView(R.layout.activity_main);  
          
        textView = (TextView) findViewById(R.id.textView1);  
        Intent intent = getIntent();  
        if (intent != null) {  
            String address = intent.getStringExtra("sms_address");  
            if (address != null) {  
                textView.append("\n\n发件人：\n" + address);  
                String bodyString = intent.getStringExtra("sms_body");  
                if (bodyString != null) {  
                    textView.append("\n短信内容：\n" + bodyString);  
                }  
            }  
        }  
    }  

}
