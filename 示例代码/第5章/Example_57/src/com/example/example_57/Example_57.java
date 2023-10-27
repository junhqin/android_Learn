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
	/*控件声明，可被全局引用*/
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private CheckBox checkbox3;
	private CheckBox checkbox4;
	private Button button;
	private Toast toast;
	public void onCreate(Bundle savedInstanceState) {   
	       super.onCreate(savedInstanceState);   
	       setContentView(R.layout.main);   //设置界面布局
	       /*根据XML中控件标签定义的属性生成控件*/
	       checkbox1 = (CheckBox) findViewById(R.id.CheckBox01);   
	       checkbox2 = (CheckBox) findViewById(R.id.CheckBox02);
	       checkbox3 = (CheckBox) findViewById(R.id.CheckBox03);
	       checkbox4 = (CheckBox) findViewById(R.id.CheckBox04);  
	       button = (Button) findViewById(R.id.Submit);   
	          
	       /*注册checkbox1，checkbox2，checkbox3，checkbox4以及button监听事件*/  
	       checkbox1.setOnCheckedChangeListener(new CheckBoxListener());//checkbox1状态改变（选中或取消选中）监听器
	       checkbox2.setOnCheckedChangeListener(new CheckBoxListener());//checkbox2状态改变（选中或取消选中）监听器
	       checkbox3.setOnCheckedChangeListener(new CheckBoxListener()); //checkbox3状态改变（选中或取消选中）监听器
	       checkbox4.setOnCheckedChangeListener(new CheckBoxListener()); //checkbox4状态改变（选中或取消选中）监听器
	       button.setOnClickListener((OnClickListener) new ButtonClickListener());//button单击监听器  
	          
	   }   
	      
	   /*定义复选框勾选状态监听器。当复选框状态发生改变时（选中变成未选中或未选中变成选中），onCheckedChanged方法被调用。*/ 
	   class CheckBoxListener implements OnCheckedChangeListener{   
	    public void onCheckedChanged(CompoundButton buttonView,   
	            boolean isChecked) {   
	        if(isChecked){ 
	        	toast=Toast.makeText(Example_57.this, buttonView.getText()+"被选择",Toast.LENGTH_SHORT );
	        	toast.setGravity(Gravity.CENTER, 5, 5);
	        	toast.show();   
	        }else{   
	        	toast=Toast.makeText(Example_57.this, buttonView.getText()+"取消选择",Toast.LENGTH_SHORT );
	        	toast.setGravity(Gravity.CENTER, 5, 5);
	        	toast.show();   
	        }   
	    }   
	   }   
	   /*定义按钮单击监听器。当单击按钮时，onClick方法被调用。*/    
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
	        Toast.makeText(Example_57.this, str+"被选择", Toast.LENGTH_LONG).show();   
		}   
	   }  
}
