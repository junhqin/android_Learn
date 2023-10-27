package com.example.example7_1handler;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {   
	/**
	 * 1.ʹ�ö��̵߳�Ч����û��10��Ⱥ���ǿ�û�����
	 * 2.˵��handler��UI����ͬһ���߳���
	 * 3.handler��post����������ʹ��
	 * 4.˵�������̲߳���ֱ���޸�UI������Ϣ
	 * 
	 * 5.ѧ��Looper-Message���ƺ󣬴�����Ϊ��ҵ��Ҫ�����߳�ͨ��Handler�޸�UI����
	 */
       
    Handler handler = new Handler();   
    
    TextView uid,uname,handlerofthreadid,handlerofthreadname;   //�����ĸ�textview�ؼ�
    @Override  
    public void onCreate(Bundle savedInstanceState) {   
        super.onCreate(savedInstanceState);   
        //�����ò����ļ�֮ǰ�ȵ���post������   
        //��ʾ��ִ�����߳�֮��Ż���ʾ�����ļ��е����ݣ����߳���������������10���ӣ�   
        //��������Ч��Ϊ������ʾӦ�ó��������棬�ȴ�10����֮�����ʾ�����ļ��е�����   
        handler.post(runable);   
        Thread t = new Thread(runable);   
        t.start();  

        setContentView(R.layout.activity_main);   
        
        
        uid=(TextView)findViewById(R.id.uid);
        uname=(TextView)findViewById(R.id.uiname);
        handlerofthreadid=(TextView)findViewById(R.id.handlerofthreadid);
        handlerofthreadname=(TextView)findViewById(R.id.handlerofthreadname);
        uid.setText("UI�̵߳��߳�id��"+Thread.currentThread().getId());
        uname.setText("UI�̵߳��߳�name��"+Thread.currentThread().getName());    
        handlerofthreadid.setText("�����߳�id��"+t.getId());
        handlerofthreadname.setText("�����߳�name��"+t.getName());
    }   
       
    Runnable runable= new Runnable(){   
  
        public void run() {   
            //�����ǰ�̵߳�id��name   
            //�������������߳�id��name������onCreate()������������߳�id��name��ͬ�Ļ���   
            //��ô���ʾ������ʹ�õ���ͬһ���߳�   
        	
        	//����ע�ʹ򿪾ͻ���ִ�����Ϊandroidֻ����UI�̸߳���UI���棬�����߳�ֱ�Ӳ���UI�ؼ��ͻ����
        	//handlerofthreadid.setText("UI�̵߳��߳�id��"+Thread.currentThread().getId());
            //handlerofthreadname.setText("UI�̵߳��߳�name��"+Thread.currentThread().getName());;
            try{   
                Thread.sleep(10000);    //���߳�����10��   
            }catch(InterruptedException e){   
                e.printStackTrace();   
            }   
        }   
    };   
}  
