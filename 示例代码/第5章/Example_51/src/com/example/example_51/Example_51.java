package com.example.example_51;

import com.example.example_51.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView; //导入TextView类

public class Example_51 extends Activity {
	@Override //标识onCreat方法是重写父类的方法。
    public void onCreate(Bundle savedInstanceState) {
        TextView myTextView; //声明一个TextView的对象
        String str="Welcome to Android World!"; //定义TextView中显示的字符串
    	   super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myTextView=(TextView) this.findViewById(R.id.myTextViewID);
        /*调用setText()方法设置Andriod屏幕上显示的字符，否则Andriod屏幕上显示的字符是main.xml中的text
        引用的字符*/
        myTextView.setText(str);
        
    }
}