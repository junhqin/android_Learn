package com.example.example2_2activity02;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity{
	private TextView mytextview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("secondactivity--oncreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		mytextview = (TextView)findViewById(R.id.textview);
		mytextview.setText(R.string.second);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.out.println("secondactivity--onpause()");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		System.out.println("secondactivity--onrestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		System.out.println("secondactivity--onresume()");
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		System.out.println("secondactivity--onstart()");
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		System.out.println("secondactivity--onstop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("secondactivity--ondestroy()");
		super.onDestroy();
	}	
}
