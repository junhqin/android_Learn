package com.example.example6_7filerw;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.file.util.FileUtil;
  

public class MainActivity extends Activity {
	private EditText etName;  
    private EditText etAge;
    private FileUtil fileutil;
    private Button btnSave;
    private Button btnSaveToSDcard;
    private Button btnRead;
    private String FileName="UserInfo.txt";
    TextView tvContent;
    Context context=this;
    String userName="";
    String userAge;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnSave=(Button)findViewById(R.id.save);
		btnSaveToSDcard=(Button)findViewById(R.id.saveToSdCard);
		btnRead=(Button)findViewById(R.id.read);
		etName=(EditText)findViewById(R.id.username);
		etAge=(EditText)findViewById(R.id.age);
		tvContent=(TextView)findViewById(R.id.tvReadContent);
		fileutil=new FileUtil(context);

		btnSave.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				   userName = etName.getText().toString();  
			       userAge = etAge.getText().toString();
			      try {
					fileutil.save(FileName, "姓名是："+userName+",年龄是："+userAge);
					 Toast.makeText(MainActivity.this, "保存成功",Toast.LENGTH_LONG).show();  
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  			
			}
		});
		btnSaveToSDcard.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				fileutil.readSDcard();	
			}
		});
		btnRead.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				   userName = etName.getText().toString();  
			       userAge = etAge.getText().toString();
				   try {  
			        	String text=fileutil.read(FileName);
			        	tvContent.setText(text);
			        	  Toast.makeText(MainActivity.this, "读取数据成功",Toast.LENGTH_LONG).show();  
			        } catch (IOException e) {  
			            e.printStackTrace();  
			        }  
			}
		});  
	}
}
