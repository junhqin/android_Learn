package com.example.example2_7danamicbroadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
public class MainActivity extends Activity {
	private Button sendStaticButton;	//发送静态注册广播的按钮
	private Button sendDynamicButton;	//发送动态注册广播的按钮
	private static final String STATICACTION = "com.lth.staticreceiver";		//静态广播的Action字符串
	private static final String DYNAMICACTION = "com.lth.dynamicreceiver";	//动态广播的Action字符串
	
	private dynamicReceiver dy_receiver;  //定义动态广播接收器对象
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendStaticButton = (Button) findViewById(R.id.send_static);		//获取Button按钮引用
		sendDynamicButton = (Button) findViewById(R.id.send_dynamic);
		sendStaticButton.setOnClickListener(new DIYOnClickListener());	//为Button按钮添加监听器
		sendDynamicButton.setOnClickListener(new DIYOnClickListener());
		
		
		//用togglebutton对动态广播接收器进行注册与解除注册
	    ToggleButton tbBindService=(ToggleButton)findViewById(R.id.register);
	    tbBindService.setOnCheckedChangeListener
	    (
	    	new OnCheckedChangeListener()
	    	{
				@Override
				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
				{
					if(isChecked)
					{//已经选中（动态注册广播接收器）
						dy_receiver=new dynamicReceiver();       //创建要动态注册的广播对象，此句必不可少
						IntentFilter dynamic_filter = new IntentFilter();  //创建Intent过滤器
						dynamic_filter.addAction(DYNAMICACTION);			//添加动态广播的Action
						registerReceiver(dy_receiver, dynamic_filter);	// 注册自定义动态广播消息
					}
					else
					{//解除动态注册广播接收器
						unregisterReceiver(dy_receiver);
					}
				}
	    	}
	    );
	}
	class DIYOnClickListener implements OnClickListener{		//内部类OnClick监听器
		public void onClick(View v) {
			if(v.getId() == R.id.send_static){		// 发送自定义静态注册广播消息
				Intent intent = new Intent();
				intent.setAction(STATICACTION);		//设置Action
				intent.putExtra("msg", "静态类型的广播！");	//添加附加信息
				sendBroadcast(intent);				//发送Intent
			}
			else if(v.getId() == R.id.send_dynamic){	// 发送自定义动态注册广播消息
				Intent intent = new Intent();
				intent.setAction(DYNAMICACTION);		//设置Action
				intent.putExtra("msg", "动态类型的广播！");		//添加附加信息
				sendBroadcast(intent);					//发送Intent
	}}}
}
