package com.example.example2_7danamicbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class dynamicReceiver extends  BroadcastReceiver  {
	@Override		//动态广播接收器执行的方法
	public void onReceive(Context context, Intent intent) {
			String msg = "我是动态广播接收器,收到了"+intent.getStringExtra("msg");
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
     }
}
