package com.example.example9_2intentsms;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button Send;
	private EditText PhoneNo;
	private EditText Content;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		Send = (Button)findViewById(R.id.Send);
		PhoneNo = (EditText)findViewById(R.id.PhoneNo);
		Content = (EditText)findViewById(R.id.Content);

		Send.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String phoneNo = PhoneNo.getText().toString();
				String message = Content.getText().toString();
				if (phoneNo.length() > 0 && message.length() > 0) {
					 Intent smsIntent=new Intent(Intent.ACTION_SENDTO,
							 Uri.parse("sms:"+PhoneNo.getText().toString()));
					 smsIntent.putExtra("sms_body", Content.getText().toString());
					 MainActivity.this.startActivity(smsIntent);
				} else
					Toast.makeText(getBaseContext(),
							"Please enter both phone number and message.",
							Toast.LENGTH_SHORT).show();
			}
		});
	}


}
