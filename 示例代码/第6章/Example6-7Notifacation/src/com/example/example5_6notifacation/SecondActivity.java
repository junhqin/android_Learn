package com.example.example5_6notifacation;

import android.app.Activity;  
import android.app.Notification;  
import android.app.NotificationManager;  
import android.app.PendingIntent;  
import android.content.Intent;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
 
public class SecondActivity extends Activity {  
    // ������ť  
    private Button cancelBtn;  
    // ����Notification  
    private Notification notification ;  
    // ����NotificationManager  
    private NotificationManager mNotification;  
    // Notification��ʾID  
    private static final int ID = 1;  
    @Override 
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_second);  
        // ʵ������ť  
        cancelBtn = (Button)findViewById(R.id.cancelButton2);  
        // ���NotificationManagerʵ��  
        String service = NOTIFICATION_SERVICE;  
        mNotification = (NotificationManager)getSystemService(service);  
          
        // ʵ����Notification  
        notification = new Notification();  
        // ������ʾͼ�꣬��ͼ�����״̬����ʾ  
        int icon = notification.icon = android.R.drawable.stat_notify_chat;   
        // ������ʾ��ʾ��Ϣ������ϢҲ����״̬����ʾ  
        String tickerText = "Notification example";   
        // ��ʾʱ��  
        long when = System.currentTimeMillis();  
        notification.icon = icon;  
        notification.tickerText = tickerText;  
        notification.when = when;  
          
        // ʵ����Intent  
        Intent intent = new Intent(this, MainActivity.class);   
        // ���PendingIntent  
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);   
        // �����¼���Ϣ  
        notification.setLatestEventInfo(this, "��Ϣ", "Hello Notification", pi);   
        // ����֪ͨ  
        mNotification.notify(ID, notification);  
          
        // Ϊ��ť��Ӽ�����  
        cancelBtn.setOnClickListener(cancelListener);  
    }  
      
    // ȡ��֪ͨ������  
     private OnClickListener cancelListener = new OnClickListener() {  
        @Override 
        public void onClick(View v) {  
            // ȡ��֪ͨ  
            mNotification.cancel(ID);  
        }  
    };  
} 
