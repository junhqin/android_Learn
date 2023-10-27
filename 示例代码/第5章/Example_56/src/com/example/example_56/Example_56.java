package com.example.example_56;

import com.example.example_56.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;//导入单选按钮包
import android.widget.RadioGroup; //导入RadioGroup
import android.widget.TextView;
import android.widget.Toast; //导入Toast包

public class Example_56 extends Activity
{
	private TextView textview;
	private RadioGroup RG;
	private RadioButton RB1,RB2,RB3,RB4,RB5,RB6;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); //设置程序布局

		/*根据XML定义生成取得 TextView、RadioGroup、RadioButton对象*/
		textview = (TextView) findViewById(R.id.textview); //生成TextView对象
		RG = (RadioGroup) findViewById(R.id.RG); //生成RadioGroup对象，该组包含6个单选按钮
		RB1 = (RadioButton) findViewById(R.id.RB1);//生成第一个单选按钮对象
		RB2 = (RadioButton) findViewById(R.id.RB2);//生成第二个单选按钮对象
		RB3 = (RadioButton) findViewById(R.id.RB3);//生成第二个单选按钮对象
		RB4 = (RadioButton) findViewById(R.id.RB4);//生成第二个单选按钮对象
		RB5 = (RadioButton) findViewById(R.id.RB5);//生成第二个单选按钮对象
		RB6 = (RadioButton) findViewById(R.id.RB6);//生成第二个单选按钮对象
		
		RG.setOnCheckedChangeListener(ChangeRadioGroup);
		/*使用setOnCheckedChangeListenerRadioGroup注册单选按钮状态改变监听器*/
	}

	private RadioGroup.OnCheckedChangeListener ChangeRadioGroup = new
	RadioGroup.OnCheckedChangeListener()
	{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			if(checkedId==RB1.getId()&& RB1.isChecked()){
				textview.setText(RB1.getText()); 
				Toast.makeText(Example_56.this, RB1.getText()+"被选择", Toast.LENGTH_LONG).show();   
			}
			/*若RB1被选中，textview显示RB1的内容：Android*/
			else if(checkedId==RB1.getId()&& RB2.isChecked()){
				textview.setText(RB2.getText()); 
				Toast.makeText(Example_56.this, RB2.getText()+"被选择", Toast.LENGTH_LONG).show();   
			}
			/*若RB2被选中，textview显示RB2的内容：Sysbian*/
			else if(checkedId==RB3.getId()&& RB3.isChecked()){
				textview.setText(RB3.getText()); 
				Toast.makeText(Example_56.this, RB3.getText()+"被选择", Toast.LENGTH_LONG).show();   
			}
			/*若RB3被选中，textview显示RB3的内容：WinCE*/
			else if(checkedId==RB4.getId()&& RB4.isChecked()){
				textview.setText(RB4.getText()); 
				Toast.makeText(Example_56.this, RB4.getText()+"被选择", Toast.LENGTH_LONG).show();   
			}
			/*若RB4被选中，textview显示RB4的内容：PalmOS*/
			else if(checkedId==RB5.getId()&& RB5.isChecked()){
				textview.setText(RB5.getText()); 
				Toast.makeText(Example_56.this, RB5.getText()+"被选择", Toast.LENGTH_LONG).show();   
			}
			/*若RB5被选中，textview显示RB5的内容：Linux*/
			else if(checkedId==RB6.getId()&& RB6.isChecked()){
				textview.setText(RB6.getText()); 
				Toast.makeText(Example_56.this, RB6.getText()+"被选择", Toast.LENGTH_LONG).show();   
			}
			/*若RB6被选中，textview显示RB6的内容：iPhoneOS*/
		}
	};
	/*定义RadioGroup状态改变事件监听器。当单选按钮的状态发生改变是，onCheckedChanged方法被调用。*/	
}

