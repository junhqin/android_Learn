package com.example.example_510;

import com.example.example_510.R;

import android.app.Activity;   //导入Activity类
import android.os.Bundle;   //导入Bundle类
/*ScrollViewApplication实现了一个手机应用*/
public class Example_510 extends Activity {
    /** Called when the activity is first created. */   
    @Override  
    public void onCreate(Bundle savedInstanceState)   
    {   
        super.onCreate(savedInstanceState);    //调用父类的onCreate方法
        setContentView(R.layout.main);   //使用main.xml生成程序布局
    }   
}
