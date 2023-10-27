package com.example.example2_2activity02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity {
	 private Button mybutton; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("firstActivity--oncreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fist);
		mybutton=(Button)findViewById(R.id.button1);
		mybutton.setText(R.string.button1);
		mybutton.setOnClickListener(new Onbuttonlistener());
	}
	class Onbuttonlistener implements OnClickListener{
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		  Intent intent = new Intent();
		  intent.setClass(FirstActivity.this,SecondActivity.class);
		  FirstActivity.this.startActivity(intent);
		}
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.out.println("firstActivity--onpause()");
		super.onPause();
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		System.out.println("firstActivity--onrestart()");
		super.onRestart();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		System.out.println("firstActivity--onresume()");
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		System.out.println("firstActivity--onstart()");
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		System.out.println("firstActivity--onstop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("firstActivity--ondestroy()");
		super.onDestroy();
	}
	
}
