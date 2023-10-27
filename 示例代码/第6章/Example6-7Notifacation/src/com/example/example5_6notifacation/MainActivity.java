package com.example.example5_6notifacation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	// ����Button  
    private Button btn;  
    // ����Broadcast Receiver action  
    private static final String NOTI_ACTION = "com.android.notification.NOTI_ACTION";  
    @Override 
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        // ���õ�ǰ������ͼ  
        setContentView(R.layout.activity_main);  
        // ʵ����Button  
        btn = (Button)findViewById(R.id.Button1);  
        // ����¼�������  
        btn.setOnClickListener(listener);  
    }  
    // �����¼�������  
    private OnClickListener listener = new OnClickListener() {  
        @Override 
        public void onClick(View v) {  
            // ʵ����Intent  
            Intent intent = new Intent();  
            // ����Intent action����  
            intent.setAction(NOTI_ACTION);  
            // ����㲥  
            sendBroadcast(intent);  
        }  
    };  
}
