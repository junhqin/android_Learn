package com.example.example5_6notifacation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	// 声明Button  
    private Button btn;  
    // 定义Broadcast Receiver action  
    private static final String NOTI_ACTION = "com.android.notification.NOTI_ACTION";  
    @Override 
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        // 设置当前布局视图  
        setContentView(R.layout.activity_main);  
        // 实例化Button  
        btn = (Button)findViewById(R.id.Button1);  
        // 添加事件监听器  
        btn.setOnClickListener(listener);  
    }  
    // 创建事件监听器  
    private OnClickListener listener = new OnClickListener() {  
        @Override 
        public void onClick(View v) {  
            // 实例化Intent  
            Intent intent = new Intent();  
            // 设置Intent action属性  
            intent.setAction(NOTI_ACTION);  
            // 发起广播  
            sendBroadcast(intent);  
        }  
    };  
}
