package com.example.example2_5remoteservice;

import com.example.example2_5remoteservice.Apple.Stub;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button;	
	private Apple apple;//Զ�̽ӿ�
	private static final String ACTION = "lth.my.action.action1";//�Զ���Action

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button)this.findViewById(R.id.button1);
		button.setOnClickListener(remoteListener);
	}
   private OnClickListener remoteListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setAction(ACTION);
			MainActivity.this.bindService(intent, connection, Service.BIND_AUTO_CREATE);
			//�󶨵�����õ��Ǹ�Service
		}
	};	
private ServiceConnection connection = new ServiceConnection() {
	
		@Override
		public void onServiceDisconnected(ComponentName name) {			
		}		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			apple = Stub.asInterface(service);
			if(apple != null){
				try {
				Toast.makeText(MainActivity.this, apple.getName(), Toast.LENGTH_LONG).show();//�˴����ýӿڶ���õķ���
				} catch (RemoteException e) {
					throw new RuntimeException(e);
				}
			}
		}
	};

}
