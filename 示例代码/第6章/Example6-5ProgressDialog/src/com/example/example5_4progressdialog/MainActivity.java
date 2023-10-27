package com.example.example5_4progressdialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn;  
    @Override 
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        btn = (Button)findViewById(R.id.Button1);  
        btn.setOnClickListener(new OnClickListener() {  
            @SuppressWarnings("deprecation")
			public void onClick(View v) {  
                //����Activity��showDialog()��������ʾ���ȶԻ���  
                showDialog(0);  
            }  
        });  
    }  

    @Override 
    protected Dialog onCreateDialog(int id) {  
        //�Խ��ȶԻ������ʵ����  
        ProgressDialog dialog = new ProgressDialog(this);  
        //������ʾ�ı���  
        dialog.setTitle("ProgressDialogʾ��");  
        dialog.setIndeterminate(true);  
        dialog.setMessage("�������ڰ�װ...");  
        dialog.setCancelable(true);  
          
        dialog.setButton(Dialog.BUTTON_POSITIVE, "ȷ��",   
                new DialogInterface.OnClickListener() {  
                    @Override 
                    public void onClick(DialogInterface dialog, int which) {  
                        dialog.cancel();  
                    }  
                }  
        );  
          
        return dialog;  
    }  
}
