package com.example.example_513;

import java.util.Calendar;

import com.example.example_513.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.DatePicker.OnDateChangedListener;

public class Example_513 extends Activity {
	private DatePicker datepicker; //����һ��˽�е�ʱ��ѡ��������
	private TextView textview; //����һ��˽���ı������
	Calendar calendar; //����Calendar����
	int cur_year, cur_month,cur_day; //�������ڱ���

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); //���ø����onCreate����
		setContentView(R.layout.main); //����main.xml���ɲ���

		datepicker = (DatePicker) this.findViewById(R.id.DatePicker);
		/*����XML��DatePicker��ǩ�еĶ�������datepicker*/
		textview = (TextView) this.findViewById(R.id.TextView);
		/*����XML��TextView��ǩ�еĶ�������textview*/
		calendar = Calendar.getInstance(); //ʹ��getInstance��������Calendar����
		cur_year = calendar.get(Calendar.YEAR); //��ȡ��ǰ����
		cur_month = calendar.get(Calendar.MONTH + 1);//��ȡ��ǰ����
		cur_day = calendar.get(Calendar.DAY_OF_MONTH);//��ȡ��ǰ����

		textview.setText("��ǰʱ�䣺" + cur_year + "��" + cur_month + "��" + cur_day + "��   "); //��ʾ��ǰ������
		datepicker.init(cur_year, cur_month, cur_day, new MyDateChangedListener()); //ע�����ڸı������
	}
	/* �״�����Activityʱ��onCreate���������á����ٴ�����Serviceʱ��������ִ��onCreate()����������ֱ��ִ��onStart()���� */
	private class MyDateChangedListener implements OnDateChangedListener
	{
		public void onDateChanged(DatePicker view, int year,
				int monthOfYear, int dayOfMonth) {
			// TODO Auto-generated method stub
			cur_year = year;
			cur_month = monthOfYear;
			cur_day = dayOfMonth;
			textview.setText("��ǰʱ�䣺" + cur_year + "��" + cur_month + "��" + cur_day + "��   ");
		}
	}
	/*MyDateChangedListener��ʵ�����ڸı�������Ĺ��ܣ������ڸı�ʱ��onDateChanged���������ø�������*/
}


