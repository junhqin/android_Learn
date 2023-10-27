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
		 * 区别于默认优先启动在activity栈中已经存在的activity（如果之前启动过，并还没有被destroy的话）
		而是无论是否存在，都重新启动新的activity
		If set, this activity will become the start of a new task on this history stack
		*/
		intent_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent_activity);
	}
}
