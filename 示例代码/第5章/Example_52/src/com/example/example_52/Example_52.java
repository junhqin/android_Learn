package com.example.example_52;

import com.example.example_52.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView.OnEditorActionListener;//提供编辑事件监听接口 
import android.view.KeyEvent;//键盘事件包   
import android.widget.EditText; //导入可编辑文本框类  
import android.widget.TextView;  //导入不可编辑文本框类   

public class Example_52 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//设置界面布局
        EditText ET_phone=(EditText)findViewById(R.id.ET_phonenumber);
        EditText ET_password=(EditText)findViewById(R.id.ET_password);
        final TextView text=(TextView)findViewById(R.id.myTextView);
        //获取XML定义的资源
        ET_phone.setOnEditorActionListener(new OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) { 
                text.setText("Editing ET_phonenumber"); //当编辑ET_phone时，修改文本框内容。
                return false;   
            } 
        });
        //编辑文本框编辑事件监听实现。当编辑ET_phone时，该方法被调用。
        ET_password.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) { 
                    text.setText("Editing ET_password");//当编辑ET_password时，修改文本框内容。
                    return false;   
                } 
            });
        //编辑文本框编辑事件监听实现。当编辑ET_password时，该方法被调用。
    }
}