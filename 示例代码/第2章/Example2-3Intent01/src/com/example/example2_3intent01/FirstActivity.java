package com.example.example2_3intent01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity {
	private Button mybutton; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		mybutton=(Button)findViewById(R.id.button1);
		mybutton.setOnClickListener(new Onbuttonlistener());
	}
	class Onbuttonlistener implements OnClickListener{
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		  Intent intent = new Intent();
		  intent.putExtra("stringname", "这是第1个页面传递的信息");
		  intent.setClass(FirstActivity.this,SecondActivity.class);
		  FirstActivity.this.startActivity(intent);
		}
	}
	
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
