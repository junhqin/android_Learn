package com.example.example7_2loopermessage;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Process;
import android.widget.TextView; 
import android.os.Handler;
import android.os.Message;
public class MainActivity extends Activity {
	private Button btn_StartTaskThread;
	private Button btn_StopTaskThread;
	private Button btn_ExitApp;
    private TextView threadOutputInfo;
	private MyTaskThread myThread = null;
    private Handler mHandler;;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threadOutputInfo = (TextView)findViewById(R.id.taskThreadOuputInfo);
        threadOutputInfo.setText("线程未运行");
        mHandler = new Handler() { 
            public void handleMessage(Message msg) { 
           	switch (msg.what)
            	{
            	case MyTaskThread.MSG_REFRESHINFO:
    		        threadOutputInfo.setText((String)(msg.obj));
            		break;
            	default:
            		break;
            	}
            }
        };
        btn_ExitApp = (Button) findViewById(R.id.exitApp);		// <退出应用>按钮的代码
        btn_ExitApp.setOnClickListener(new  OnClickListener(){
            public void onClick(View v) {
				finish();
            	Process.killProcess(Process.myPid());
            }
        });
        btn_StartTaskThread = (Button) findViewById(R.id.startTaskThread); // <开始运行线程>的代码
        btn_StartTaskThread.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	myThread = new MyTaskThread(mHandler);	// 创建一个线程
            	myThread.start();							// 启动线程
            	setButtonAvailable();
             }
        });
        btn_StopTaskThread = (Button) findViewById(R.id.stopTaskThread);	//<中止线程运行>的代码
        btn_StopTaskThread.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	if (myThread!=null && myThread.isAlive())
            		myThread.stopRun();
            	try {
            		if (myThread!=null){
            			myThread.join(); 					// 等待线程运行结束
            			myThread =null;
            		}
            	} catch (InterruptedException e) {	
            		// 空语句块，表示忽略强行中止异常
            	}
            	setButtonAvailable();
             }
        });
        setButtonAvailable();
    }
    private void setButtonAvailable()	// 新增函数，用于设置各按钮的可选性
    {
    	btn_StartTaskThread.setEnabled(myThread==null); 
    	btn_ExitApp.setEnabled(myThread==null); 
    	btn_StopTaskThread.setEnabled(myThread!=null); 
    }
}