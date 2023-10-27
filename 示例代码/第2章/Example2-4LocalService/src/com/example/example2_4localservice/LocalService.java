package com.example.example2_4localservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LocalService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("onBind()方法");
		return null;
	}
	@Override
	//当创建service对象时，首先调用的方法
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("LocalService:onCreate()创建服务");
	}
	@Override
	public int onStartCommand(Intent intent, int flags,int startId) {
		// TODO Auto-generated method stub
        System.out.println("LocalService:onStartcommand()启动服务");
        System.out.println( flags+","+startId+","+intent);
        super.onStartCommand(intent, flags, startId);
        return super.onStartCommand(intent, flags, startId);  
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("LocalService:onDestroy() 销毁服务");
	}

}