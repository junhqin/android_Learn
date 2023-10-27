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
	        //ʵ����AlertDialog.Builder����  
	        final AlertDialog.Builder builder = new AlertDialog.Builder(this);           
	        btn.setOnClickListener(new OnClickListener() {  
	            public void onClick(View v) {  
	                //������ʾ��Ϣ��ȷ����ť  
	                builder.setMessage("���Ҫɾ������ϵ����").setPositiveButton("��", new DialogInterface.OnClickListener() {  
	                    public void onClick(DialogInterface dialog, int which) {  
	                        tv.setText("�ɹ�ɾ��");  
	                    }  
	                    //����ȡ����ť  
	                }).setNegativeButton("��", new DialogInterface.OnClickListener() {  
	                    public void onClick(DialogInterface dialog, int which) {  
	                        tv.setText("ȡ��ɾ��");  
	                    }  
	                });  
	                //�����Ի���  
	                AlertDialog ad = builder.create();  
	                //��ʾ�Ի���  
	                ad.show();  
	            }  
	        }  
	        );  
	    }  
}
