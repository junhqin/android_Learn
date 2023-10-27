package com.example.example6_5sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	 EditText etName;
	 EditText etAge;
	 Button btnRead;
	 Button btnWrite;
	 TextView tv;
	 SharedPreferences sp ;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 //��ȡSharedPreferences����
		 Context ctx = MainActivity.this;       
		  sp = ctx.getSharedPreferences("SP", MODE_PRIVATE);
		 
		 //��ȡ�ؼ�����
		 etName=(EditText)findViewById(R.id.etName);
		 etAge=(EditText)findViewById(R.id.etAge);
		 btnRead=(Button)findViewById(R.id.btnRead);
		 btnWrite=(Button)findViewById(R.id.btnWrite);
		 tv=(TextView)findViewById(R.id.tvRead);
		 
		//��ť����¼�
		 btnWrite.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=etName.getText().toString();
				int age=Integer.parseInt(etAge.getText().toString());
				 //��������
				 Editor editor = sp.edit();
				 editor.putString("Name", name);
				 editor.putInt("Age", age);
				 editor.commit();
			}
		});
		 
		 btnRead.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String nameRead=sp.getString("Name", "NOT EXIT!");
				int ageRead=sp.getInt("Age", 0);
				String textRead="��SharedPreferences�����ж����������ǣ�������"+nameRead+"�������ǣ�"+ageRead+"��";
				tv.setText(textRead);
			}
		});
	}	

}
