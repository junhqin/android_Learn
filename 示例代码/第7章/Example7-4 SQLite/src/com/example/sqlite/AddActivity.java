package com.example.sqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity{
MydbOpen mydb;
Context context=this;

	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.add);
		super.onCreate(savedInstanceState);
		

				Intent in=new Intent();
				in.setClass(context, MainActivity.class);
				startActivity(in);
				
	

	}



}
