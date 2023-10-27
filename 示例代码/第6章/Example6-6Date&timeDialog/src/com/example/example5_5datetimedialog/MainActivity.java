package com.example.example5_5datetimedialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	private Button btn1,btn2;  
    private TextView tv_1,tv_2;  
    private Calendar c;//获得日历实例  
    private int m_year,m_month,m_day;  
    private int m_hour,m_minute;  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        btn1 = (Button)findViewById(R.id.Button1);  
        btn2 = (Button)findViewById(R.id.Button2);           
        c = Calendar.getInstance();           
        m_year = c.get(Calendar.YEAR);  
        m_month = c.get(Calendar.MONTH);  
        m_day = c.get(Calendar.DAY_OF_MONTH);           
        m_hour = c.get(Calendar.HOUR);  
        m_minute = c.get(Calendar.MINUTE);           
        tv_1 = (TextView)findViewById(R.id.TextView1);           
        tv_1.setText(m_year+":"+(m_month+1)+":"+m_day);//设置TextView里的内容为日期           
        tv_2 = (TextView)findViewById(R.id.TextView2);  
        tv_2.setText(m_hour+":"+m_minute);//设置TextView里的内容为时间           
        btn1.setOnClickListener(new OnClickListener() {  
            public void onClick(View v) {  
                showDialog(0);//显示日期对话框  
            }  
        });            
        btn2.setOnClickListener(new OnClickListener() {  
            public void onClick(View v) {  
                showDialog(1);//显示时间对话框  
            }  
        });  
    }  
    //调用Activity的showDialog( )方法显示进对话框  
    protected Dialog onCreateDialog(int id) {  
        if(id==0)  
           return new DatePickerDialog(this,l1,m_year, m_month, m_day);                  
        else 
            return new TimePickerDialog(this, l2, m_hour, m_minute, false);                   
    }  
    //设置日期监听器  
    private OnDateSetListener l1 = new OnDateSetListener() {  
        public void onDateSet(DatePicker view, int year, int monthOfYear,  
                int dayOfMonth) {  
            m_year = year;  
            m_month = monthOfYear;  
            m_day = dayOfMonth;  
            tv_1.setText(m_year+":"+(m_month+1)+":"+m_day);//为TextView设置文本内容，重新显示日期  
        }  
    };  
    //设置时间监听器  
    private OnTimeSetListener l2 = new OnTimeSetListener() {  
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {  
            m_hour = hourOfDay;  
            m_minute = minute;  
            tv_2.setText(m_hour+":"+m_minute);//为TextView设置文本内容，重新显示时间  
        }  
    };  
}
