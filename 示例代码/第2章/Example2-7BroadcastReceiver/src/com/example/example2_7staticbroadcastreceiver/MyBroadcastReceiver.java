package com.example.example2_7staticbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Intent intent_activity=new Intent(context, MainActivity.class);
		/**
		 * Intent.FLAG_ACTIVITY_NEW_TASK
		 * ������Ĭ������������activityջ���Ѿ����ڵ�activity�����֮ǰ������������û�б�destroy�Ļ���
		���������Ƿ���ڣ������������µ�activity
		If set, this activity will become the start of a new task on this history stack
		*/
		intent_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent_activity);
	}
}
