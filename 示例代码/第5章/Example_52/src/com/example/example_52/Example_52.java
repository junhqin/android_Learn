package com.example.example_52;

import com.example.example_52.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView.OnEditorActionListener;//�ṩ�༭�¼������ӿ� 
import android.view.KeyEvent;//�����¼���   
import android.widget.EditText; //����ɱ༭�ı�����  
import android.widget.TextView;  //���벻�ɱ༭�ı�����   

public class Example_52 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//���ý��沼��
        EditText ET_phone=(EditText)findViewById(R.id.ET_phonenumber);
        EditText ET_password=(EditText)findViewById(R.id.ET_password);
        final TextView text=(TextView)findViewById(R.id.myTextView);
        //��ȡXML�������Դ
        ET_phone.setOnEditorActionListener(new OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) { 
                text.setText("Editing ET_phonenumber"); //���༭ET_phoneʱ���޸��ı������ݡ�
                return false;   
            } 
        });
        //�༭�ı���༭�¼�����ʵ�֡����༭ET_phoneʱ���÷��������á�
        ET_password.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) { 
                    text.setText("Editing ET_password");//���༭ET_passwordʱ���޸��ı������ݡ�
                    return false;   
                } 
            });
        //�༭�ı���༭�¼�����ʵ�֡����༭ET_passwordʱ���÷��������á�
    }
}