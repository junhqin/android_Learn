package com.example.example2_5remoteservice;

import com.example.example2_5remoteservice.Apple.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class remoteService extends Service {
	
	private Stub binder = new redApple();
	
	@Override
	public IBinder onBind(Intent arg0) {
		return binder;
	}

}