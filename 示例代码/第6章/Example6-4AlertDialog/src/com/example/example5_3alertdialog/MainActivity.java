package com.example.example5_3alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	 private TextView tv;  
	    private Button btn;  
	      
	    @Override 
	    public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.activity_main);  
	        tv = (TextView)findViewById(R.id.TextView1);  
	        btn = (Button)findViewById(R.id.Button1);  
	        //实例化AlertDialog.Builder对象  
	        final AlertDialog.Builder builder = new AlertDialog.Builder(this);           
	        btn.setOnClickListener(new OnClickListener() {  
	            public void onClick(View v) {  
	                //设置提示信息，确定按钮  
	                builder.setMessage("真的要删除该联系人吗？").setPositiveButton("是", new DialogInterface.OnClickListener() {  
	                    public void onClick(DialogInterface dialog, int which) {  
	                        tv.setText("成功删除");  
	                    }  
	                    //设置取消按钮  
	                }).setNegativeButton("否", new DialogInterface.OnClickListener() {  
	                    public void onClick(DialogInterface dialog, int which) {  
	                        tv.setText("取消删除");  
	                    }  
	                });  
	                //创建对话框  
	                AlertDialog ad = builder.create();  
	                //显示对话框  
	                ad.show();  
	            }  
	        }  
	        );  
	    }  
}
