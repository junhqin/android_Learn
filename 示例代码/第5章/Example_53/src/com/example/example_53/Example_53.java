package com.example.example_53;

import com.example.example_53.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;
import android.graphics.drawable.Drawable;//����Drawable��,ͨ���������Ӧ��XML�ļ��ж������Դ ����ɫ��ͼƬ
import android.content.res.Resources;//Resources���ṩ�˻�ȡDrawable����ķ���
import android.graphics.Color;//Color���ṩ�˳�����12����ɫ����
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
            	//�����button1ʱ���޸�textview�е��ı�
            	if (textview.getBackground() != red_Drawable)
                	 textview.setBackgroundDrawable(red_Drawable);
            	//����ǰtextview������ɫ���Ǻ�ɫ�����޸ı�����ɫΪ��ɫ
            } 
        });       
        //ʵ��button1�ĵ�����������         
        button2.setOnClickListener(listener);
        button3.setOnClickListener(this); 
    }    
    OnClickListener listener = new OnClickListener() {  
    	public void onClick(View v) { 
        	String str = "You have clicked " + button2.getText().toString(); 
        	textview.setText(str);
        	//�����button2ʱ���޸�textviewΪstr�������ַ���
        	if (textview.getBackground() != blue_Drawable)
            	 textview.setBackgroundDrawable(blue_Drawable);
        	//����ǰtextview������ɫ������ɫ�����޸ı�����ɫΪ��ɫ
        } 
    };      
    public void onClick(View v) { 
    	String str = "You have clicked " + button3.getText().toString(); 
    	textview.setText(str);
    	//�����button3ʱ���޸�textviewΪstr�������ַ���
    	if (textview.getBackground() != yellow_Drawable)
        	 textview.setBackgroundColor(Color.YELLOW);
    	//����ǰtextview������ɫ���ǻ�ɫ�����޸ı�����ɫΪ��ɫ    	 
    }    
    //ʵ��button3�ĵ�����������
    public void onButtonClick(View v){
    	String str = "You have clicked " + button4.getText().toString(); 
    	textview.setText(str);
    	//�����button4ʱ���޸�textviewΪstr�������ַ���
    	if (textview.getBackground() != green_Drawable)
        	 textview.setBackgroundColor(Color.GREEN);
    	//����ǰtextview������ɫ������ɫ�����޸ı�����ɫΪ��ɫ
    }
}