package com.example.example5_1optionmenu_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch (item.getItemId()) {
         case R.id.item01:
                 Toast.makeText(this, "����˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case R.id.item02:
                 Toast.makeText(this, "��Ӳ˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case R.id.item03:
                 Toast.makeText(this, "�༭�˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case R.id.item04:
                 Toast.makeText(this, "ɾ���˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case R.id.item05:
                 Toast.makeText(this, "����˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case R.id.item06:
                 Toast.makeText(this, "�����˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         }
         return false;
	}
}
