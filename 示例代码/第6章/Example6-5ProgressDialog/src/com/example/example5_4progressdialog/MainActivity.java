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
                //调用Activity的showDialog()方法，显示进度对话框  
                showDialog(0);  
            }  
        });  
    }  

    @Override 
    protected Dialog onCreateDialog(int id) {  
        //对进度对话框进行实例化  
        ProgressDialog dialog = new ProgressDialog(this);  
        //设置显示的标题  
        dialog.setTitle("ProgressDialog示例");  
        dialog.setIndeterminate(true);  
        dialog.setMessage("程序正在安装...");  
        dialog.setCancelable(true);  
          
        dialog.setButton(Dialog.BUTTON_POSITIVE, "确定",   
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
