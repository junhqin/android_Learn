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
    // 声明按钮  
    private Button cancelBtn;  
    // 声明Notification  
    private Notification notification ;  
    // 声明NotificationManager  
    private NotificationManager mNotification;  
    // Notification标示ID  
    private static final int ID = 1;  
    @Override 
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_second);  
        // 实例化按钮  
        cancelBtn = (Button)findViewById(R.id.cancelButton2);  
        // 获得NotificationManager实例  
        String service = NOTIFICATION_SERVICE;  
        mNotification = (NotificationManager)getSystemService(service);  
          
        // 实例化Notification  
        notification = new Notification();  
        // 设置显示图标，该图标会在状态栏显示  
        int icon = notification.icon = android.R.drawable.stat_notify_chat;   
        // 设置显示提示信息，该信息也会在状态栏显示  
        String tickerText = "Notification example";   
        // 显示时间  
        long when = System.currentTimeMillis();  
        notification.icon = icon;  
        notification.tickerText = tickerText;  
        notification.when = when;  
          
        // 实例化Intent  
        Intent intent = new Intent(this, MainActivity.class);   
        // 获得PendingIntent  
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);   
        // 设置事件信息  
        notification.setLatestEventInfo(this, "消息", "Hello Notification", pi);   
        // 发出通知  
        mNotification.notify(ID, notification);  
          
        // 为按钮添加监听器  
        cancelBtn.setOnClickListener(cancelListener);  
    }  
      
    // 取消通知监听器  
     private OnClickListener cancelListener = new OnClickListener() {  
        @Override 
        public void onClick(View v) {  
            // 取消通知  
            mNotification.cancel(ID);  
        }  
    };  
} 
