package com.example.example2_7danamicbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class dynamicReceiver extends  BroadcastReceiver  {
	@Override		//��̬�㲥������ִ�еķ���
	public void onReceive(Context context, Intent intent) {
			String msg = "���Ƕ�̬�㲥������,�յ���"+intent.getStringExtra("msg");
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
     }
}
