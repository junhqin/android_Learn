package com.example.example_56;

import com.example.example_56.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;//���뵥ѡ��ť��
import android.widget.RadioGroup; //����RadioGroup
import android.widget.TextView;
import android.widget.Toast; //����Toast��

public class Example_56 extends Activity
{
	private TextView textview;
	private RadioGroup RG;
	private RadioButton RB1,RB2,RB3,RB4,RB5,RB6;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); //���ó��򲼾�

		/*����XML��������ȡ�� TextView��RadioGroup��RadioButton����*/
		textview = (TextView) findViewById(R.id.textview); //����TextView����
		RG = (RadioGroup) findViewById(R.id.RG); //����RadioGroup���󣬸������6����ѡ��ť
		RB1 = (RadioButton) findViewById(R.id.RB1);//���ɵ�һ����ѡ��ť����
		RB2 = (RadioButton) findViewById(R.id.RB2);//���ɵڶ�����ѡ��ť����
		RB3 = (RadioButton) findViewById(R.id.RB3);//���ɵڶ�����ѡ��ť����
		RB4 = (RadioButton) findViewById(R.id.RB4);//���ɵڶ�����ѡ��ť����
		RB5 = (RadioButton) findViewById(R.id.RB5);//���ɵڶ�����ѡ��ť����
		RB6 = (RadioButton) findViewById(R.id.RB6);//���ɵڶ�����ѡ��ť����
		
		RG.setOnCheckedChangeListener(ChangeRadioGroup);
		/*ʹ��setOnCheckedChangeListenerRadioGroupע�ᵥѡ��ť״̬�ı������*/
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
				Toast.makeText(Example_56.this, RB1.getText()+"��ѡ��", Toast.LENGTH_LONG).show();   
			}
			/*��RB1��ѡ�У�textview��ʾRB1�����ݣ�Android*/
			else if(checkedId==RB1.getId()&& RB2.isChecked()){
				textview.setText(RB2.getText()); 
				Toast.makeText(Example_56.this, RB2.getText()+"��ѡ��", Toast.LENGTH_LONG).show();   
			}
			/*��RB2��ѡ�У�textview��ʾRB2�����ݣ�Sysbian*/
			else if(checkedId==RB3.getId()&& RB3.isChecked()){
				textview.setText(RB3.getText()); 
				Toast.makeText(Example_56.this, RB3.getText()+"��ѡ��", Toast.LENGTH_LONG).show();   
			}
			/*��RB3��ѡ�У�textview��ʾRB3�����ݣ�WinCE*/
			else if(checkedId==RB4.getId()&& RB4.isChecked()){
				textview.setText(RB4.getText()); 
				Toast.makeText(Example_56.this, RB4.getText()+"��ѡ��", Toast.LENGTH_LONG).show();   
			}
			/*��RB4��ѡ�У�textview��ʾRB4�����ݣ�PalmOS*/
			else if(checkedId==RB5.getId()&& RB5.isChecked()){
				textview.setText(RB5.getText()); 
				Toast.makeText(Example_56.this, RB5.getText()+"��ѡ��", Toast.LENGTH_LONG).show();   
			}
			/*��RB5��ѡ�У�textview��ʾRB5�����ݣ�Linux*/
			else if(checkedId==RB6.getId()&& RB6.isChecked()){
				textview.setText(RB6.getText()); 
				Toast.makeText(Example_56.this, RB6.getText()+"��ѡ��", Toast.LENGTH_LONG).show();   
			}
			/*��RB6��ѡ�У�textview��ʾRB6�����ݣ�iPhoneOS*/
		}
	};
	/*����RadioGroup״̬�ı��¼�������������ѡ��ť��״̬�����ı��ǣ�onCheckedChanged���������á�*/	
}

