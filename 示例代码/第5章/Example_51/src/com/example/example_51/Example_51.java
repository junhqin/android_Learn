package com.example.example_51;

import com.example.example_51.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView; //����TextView��

public class Example_51 extends Activity {
	@Override //��ʶonCreat��������д����ķ�����
    public void onCreate(Bundle savedInstanceState) {
        TextView myTextView; //����һ��TextView�Ķ���
        String str="Welcome to Android World!"; //����TextView����ʾ���ַ���
    	   super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myTextView=(TextView) this.findViewById(R.id.myTextViewID);
        /*����setText()��������Andriod��Ļ����ʾ���ַ�������Andriod��Ļ����ʾ���ַ���main.xml�е�text
        ���õ��ַ�*/
        myTextView.setText(str);
        
    }
}