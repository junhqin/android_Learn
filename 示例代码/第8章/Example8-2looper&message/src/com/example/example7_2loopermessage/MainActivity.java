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
        threadOutputInfo.setText("�߳�δ����");
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
        btn_ExitApp = (Button) findViewById(R.id.exitApp);		// <�˳�Ӧ��>��ť�Ĵ���
        btn_ExitApp.setOnClickListener(new  OnClickListener(){
            public void onClick(View v) {
				finish();
            	Process.killProcess(Process.myPid());
            }
        });
        btn_StartTaskThread = (Button) findViewById(R.id.startTaskThread); // <��ʼ�����߳�>�Ĵ���
        btn_StartTaskThread.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	myThread = new MyTaskThread(mHandler);	// ����һ���߳�
            	myThread.start();							// �����߳�
            	setButtonAvailable();
             }
        });
        btn_StopTaskThread = (Button) findViewById(R.id.stopTaskThread);	//<��ֹ�߳�����>�Ĵ���
        btn_StopTaskThread.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	if (myThread!=null && myThread.isAlive())
            		myThread.stopRun();
            	try {
            		if (myThread!=null){
            			myThread.join(); 					// �ȴ��߳����н���
            			myThread =null;
            		}
            	} catch (InterruptedException e) {	
            		// �����飬��ʾ����ǿ����ֹ�쳣
            	}
            	setButtonAvailable();
             }
        });
        setButtonAvailable();
    }
    private void setButtonAvailable()	// �����������������ø���ť�Ŀ�ѡ��
    {
    	btn_StartTaskThread.setEnabled(myThread==null); 
    	btn_ExitApp.setEnabled(myThread==null); 
    	btn_StopTaskThread.setEnabled(myThread!=null); 
    }
}