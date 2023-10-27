package com.example.example_513;

import java.util.Calendar;

import com.example.example_513.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.DatePicker.OnDateChangedListener;

public class Example_513 extends Activity {
	private DatePicker datepicker; //声明一个私有的时间选择器对象
	private TextView textview; //声明一个私有文本框对象
	Calendar calendar; //声明Calendar对象
	int cur_year, cur_month,cur_day; //声明日期变量

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); //调用父类的onCreate方法
		setContentView(R.layout.main); //根据main.xml生成布局

		datepicker = (DatePicker) this.findViewById(R.id.DatePicker);
		/*根据XML的DatePicker标签中的定义生成datepicker*/
		textview = (TextView) this.findViewById(R.id.TextView);
		/*根据XML的TextView标签中的定义生成textview*/
		calendar = Calendar.getInstance(); //使用getInstance方法生成Calendar对象
		cur_year = calendar.get(Calendar.YEAR); //获取当前的年
		cur_month = calendar.get(Calendar.MONTH + 1);//获取当前的月
		cur_day = calendar.get(Calendar.DAY_OF_MONTH);//获取当前的天

		textview.setText("当前时间：" + cur_year + "年" + cur_month + "月" + cur_day + "日   "); //显示当前的日期
		datepicker.init(cur_year, cur_month, cur_day, new MyDateChangedListener()); //注册日期改变监听器
	}
	/* 首次启动Activity时，onCreate方法被调用。若再次启动Service时，不会再执行onCreate()方法，而是直接执行onStart()方法 */
	private class MyDateChangedListener implements OnDateChangedListener
	{
		public void onDateChanged(DatePicker view, int year,
				int monthOfYear, int dayOfMonth) {
			// TODO Auto-generated method stub
			cur_year = year;
			cur_month = monthOfYear;
			cur_day = dayOfMonth;
			textview.setText("当前时间：" + cur_year + "年" + cur_month + "月" + cur_day + "日   ");
		}
	}
	/*MyDateChangedListener类实现日期改变监听器的功能，当日期改变时，onDateChanged方法被调用更新日期*/
}


