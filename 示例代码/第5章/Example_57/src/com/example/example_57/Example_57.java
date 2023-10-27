package com.example.example_57;


import com.example.example_57.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Button;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class Example_57 extends Activity {
	/*�ؼ��������ɱ�ȫ������*/
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private CheckBox checkbox3;
	private CheckBox checkbox4;
	private Button button;
	private Toast toast;
	public void onCreate(Bundle savedInstanceState) {   
	       super.onCreate(savedInstanceState);   
	       setContentView(R.layout.main);   //���ý��沼��
	       /*����XML�пؼ���ǩ������������ɿؼ�*/
	       checkbox1 = (CheckBox) findViewById(R.id.CheckBox01);   
	       checkbox2 = (CheckBox) findViewById(R.id.CheckBox02);
	       checkbox3 = (CheckBox) findViewById(R.id.CheckBox03);
	       checkbox4 = (CheckBox) findViewById(R.id.CheckBox04);  
	       button = (Button) findViewById(R.id.Submit);   
	          
	       /*ע��checkbox1��checkbox2��checkbox3��checkbox4�Լ�button�����¼�*/  
	       checkbox1.setOnCheckedChangeListener(new CheckBoxListener());//checkbox1״̬�ı䣨ѡ�л�ȡ��ѡ�У�������
	       checkbox2.setOnCheckedChangeListener(new CheckBoxListener());//checkbox2״̬�ı䣨ѡ�л�ȡ��ѡ�У�������
	       checkbox3.setOnCheckedChangeListener(new CheckBoxListener()); //checkbox3״̬�ı䣨ѡ�л�ȡ��ѡ�У�������
	       checkbox4.setOnCheckedChangeListener(new CheckBoxListener()); //checkbox4״̬�ı䣨ѡ�л�ȡ��ѡ�У�������
	       button.setOnClickListener((OnClickListener) new ButtonClickListener());//button����������  
	          
	   }   
	      
	   /*���帴ѡ��ѡ״̬������������ѡ��״̬�����ı�ʱ��ѡ�б��δѡ�л�δѡ�б��ѡ�У���onCheckedChanged���������á�*/ 
	   class CheckBoxListener implements OnCheckedChangeListener{   
	    public void onCheckedChanged(CompoundButton buttonView,   
	            boolean isChecked) {   
	        if(isChecked){ 
	        	toast=Toast.makeText(Example_57.this, buttonView.getText()+"��ѡ��",Toast.LENGTH_SHORT );
	        	toast.setGravity(Gravity.CENTER, 5, 5);
	        	toast.show();   
	        }else{   
	        	toast=Toast.makeText(Example_57.this, buttonView.getText()+"ȡ��ѡ��",Toast.LENGTH_SHORT );
	        	toast.setGravity(Gravity.CENTER, 5, 5);
	        	toast.show();   
	        }   
	    }   
	   }   
	   /*���尴ť��������������������ťʱ��onClick���������á�*/    
	   class ButtonClickListener implements OnClickListener{   
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String str = ""; 
			if(checkbox1.isChecked())   
				str = str+checkbox1.getText();   
	        if(checkbox2.isChecked())   
	        	str = str +checkbox2.getText(); 
	        if(checkbox3.isChecked())   
	        	str = str +checkbox3.getText();
	        if(checkbox4.isChecked())   
	        	str = str +checkbox4.getText(); 
	        Toast.makeText(Example_57.this, str+"��ѡ��", Toast.LENGTH_LONG).show();   
		}   
	   }  
}
