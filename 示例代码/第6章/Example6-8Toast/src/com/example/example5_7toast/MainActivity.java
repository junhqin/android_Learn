package com.example.example5_7toast;

import android.app.Activity;  
import android.content.Context;  
import android.os.Bundle;  
import android.view.Gravity;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
import android.widget.ImageView;  
import android.widget.LinearLayout;  
import android.widget.Toast;  
 
public class MainActivity extends Activity  {  
    private Button button1, button2, button3,button4, button5;  
    private Toast toast = null;  
 
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        // TODO Auto-generated method stub  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        button1 = (Button) findViewById(R.id.button1);  
        button2 = (Button) findViewById(R.id.button2);  
        button3 = (Button) findViewById(R.id.button3);  
        button4 = (Button) findViewById(R.id.button4);  
        button5 = (Button) findViewById(R.id.button5);  
        button1.setOnClickListener(new ButtonClick());  
        button2.setOnClickListener(new ButtonClick());  
        button3.setOnClickListener(new ButtonClick());  
        button4.setOnClickListener(new ButtonClick());  
        button5.setOnClickListener(new ButtonClick());  
    }  
class ButtonClick implements OnClickListener{   
    @Override  
    public void onClick(View v) {  
        // TODO Auto-generated method stub  
        switch (v.getId()) {  
        case R.id.button1:  
            toast.makeText(MainActivity.this, "Ĭ�ϵ�Toast��ʾ", Toast.LENGTH_LONG).show();  
            break;  
 
        case R.id.button2:  
            // getApplicationContext()�õ�����ǰ��Ĭ��Context  
            toast = Toast.makeText(getApplicationContext(), "�Զ���λ�õ�Toast��ʾ",  
                    Toast.LENGTH_LONG);  
            //����Toast��λ��    
            toast.setGravity(Gravity.CENTER, toast.getXOffset()/2, toast.getYOffset()/2);  
            toast.show();  
            break;  
 
        case R.id.button3:  
            toast = Toast.makeText(getApplicationContext(), "ֻ��ͼƬ��Toast��ʾ",  
                    Toast.LENGTH_LONG);  
            ImageView img = new ImageView(MainActivity.this);  
            img.setImageResource(R.drawable.ic_launcher);  
            toast.setView(img);  
            toast.show();  
            break;  
 
        case R.id.button4:  
            toast = Toast.makeText(getApplicationContext(), "��ͼ���ֵ�Toast", Toast.LENGTH_LONG);   
            LinearLayout layout = (LinearLayout)toast.getView();   
            ImageView img1 = new ImageView(getApplicationContext());   
            img1.setImageResource(R.drawable.ic_launcher);   
            layout.addView(img1,0);   
            toast.show();   
            break;  
              
        case R.id.button5:  
            //��һ��xml����ת����һ��view����  
            LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);   
            View view=inflater.inflate(R.layout.toast,null);   
              
            Toast toast = new Toast(getApplicationContext());   
            //��view�в��Ҳ���ImageView�ؼ�    
            ImageView image = (ImageView) view.findViewById(R.id.img);    
            image.setImageResource(R.drawable.ic_launcher);    
            toast.setView(view);   
            toast.show();  
            break;  
              
        default:  
            break;  
        }  
    }  
  }  
}  