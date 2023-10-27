package com.example.example2_3intent01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
public class SecondActivity extends Activity{
	private TextView mytextview;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Intent intent = getIntent();
		String value=intent.getStringExtra("stringname");
		mytextview = (TextView)findViewById(R.id.textView2);
		mytextview.setText(value);
	}
}
