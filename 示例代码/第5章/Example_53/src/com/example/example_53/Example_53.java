package com.example.example_53;

import com.example.example_53.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;
import android.graphics.drawable.Drawable;//导入Drawable类,通过该类对象应用XML文件中定义的资源 如颜色、图片
import android.content.res.Resources;//Resources包提供了获取Drawable对象的方法
import android.graphics.Color;//Color包提供了常见的12种颜色常量
import android.view.View.OnClickListener;


public class Example_53 extends Activity implements OnClickListener{
    TextView textview;
    Resources resource;
   
    final Button button1 = (Button) findViewById(R.id.myButton1);
    final Button button2 = (Button) findViewById(R.id.myButton2);
    final Button button3 = (Button) findViewById(R.id.myButton3);
    final Button button4 = (Button) findViewById(R.id.myButton4); 
    final Drawable red_Drawable = resource.getDrawable(R.drawable.RED);
    final Drawable blue_Drawable = resource.getDrawable(R.drawable.BLUE);
    final Drawable yellow_Drawable = resource.getDrawable(R.drawable.YELLOW);
    final Drawable green_Drawable = resource.getDrawable(R.drawable.GREEN);
    
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        textview = (TextView) findViewById(R.id.myTextView);
        resource = this.getBaseContext().getResources();
        
        button1.setOnClickListener(new View.OnClickListener() { 
            public void onClick(View v) {
            	String str = "You have clicked " + button1.getText().toString(); 
            	textview.setText(str);
            	//当点击button1时，修改textview中的文本
            	if (textview.getBackground() != red_Drawable)
                	 textview.setBackgroundDrawable(red_Drawable);
            	//若当前textview背景颜色不是红色，则修改背景颜色为红色
            } 
        });       
        //实现button1的单击监听方法         
        button2.setOnClickListener(listener);
        button3.setOnClickListener(this); 
    }    
    OnClickListener listener = new OnClickListener() {  
    	public void onClick(View v) { 
        	String str = "You have clicked " + button2.getText().toString(); 
        	textview.setText(str);
        	//当点击button2时，修改textview为str包含的字符串
        	if (textview.getBackground() != blue_Drawable)
            	 textview.setBackgroundDrawable(blue_Drawable);
        	//若当前textview背景颜色不是蓝色，则修改背景颜色为蓝色
        } 
    };      
    public void onClick(View v) { 
    	String str = "You have clicked " + button3.getText().toString(); 
    	textview.setText(str);
    	//当点击button3时，修改textview为str包含的字符串
    	if (textview.getBackground() != yellow_Drawable)
        	 textview.setBackgroundColor(Color.YELLOW);
    	//若当前textview背景颜色不是黄色，则修改背景颜色为黄色    	 
    }    
    //实现button3的单击监听方法
    public void onButtonClick(View v){
    	String str = "You have clicked " + button4.getText().toString(); 
    	textview.setText(str);
    	//当点击button4时，修改textview为str包含的字符串
    	if (textview.getBackground() != green_Drawable)
        	 textview.setBackgroundColor(Color.GREEN);
    	//若当前textview背景颜色不是绿色，则修改背景颜色为绿色
    }
}