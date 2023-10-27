package com.example.example7_1handler;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {   
	/**
	 * 1.使用多线程的效果，没有10秒等候，增强用户体验
	 * 2.说明handler与UI处于同一个线程中
	 * 3.handler的post（）方法的使用
	 * 4.说明辅助线程不能直接修改UI界面信息
	 * 
	 * 5.学完Looper-Message机制后，此例作为作业，要求辅助线程通过Handler修改UI界面
	 */
       
    Handler handler = new Handler();   
    
    TextView uid,uname,handlerofthreadid,handlerofthreadname;   //定义四个textview控件
    @Override  
    public void onCreate(Bundle savedInstanceState) {   
        super.onCreate(savedInstanceState);   
        //在设置布局文件之前先调用post方法，   
        //表示在执行完线程之后才会显示布局文件中的内容，而线程中又设置了休眠10秒钟，   
        //所以最终效果为，先显示应用程序主界面，等待10秒钟之后才显示布局文件中的内容   
        handler.post(runable);   
        Thread t = new Thread(runable);   
        t.start();  

        setContentView(R.layout.activity_main);   
        
        
        uid=(TextView)findViewById(R.id.uid);
        uname=(TextView)findViewById(R.id.uiname);
        handlerofthreadid=(TextView)findViewById(R.id.handlerofthreadid);
        handlerofthreadname=(TextView)findViewById(R.id.handlerofthreadname);
        uid.setText("UI线程的线程id："+Thread.currentThread().getId());
        uname.setText("UI线程的线程name："+Thread.currentThread().getName());    
        handlerofthreadid.setText("辅助线程id："+t.getId());
        handlerofthreadname.setText("辅助线程name："+t.getName());
    }   
       
    Runnable runable= new Runnable(){   
  
        public void run() {   
            //输出当前线程的id和name   
            //如果这里输出的线程id、name与上面onCreate()方法中输出的线程id、name相同的话，   
            //那么则表示，他们使用的是同一个线程   
        	
        	//下面注释打开就会出现错误，因为android只允许UI线程更新UI界面，辅助线程直接操作UI控件就会出错
        	//handlerofthreadid.setText("UI线程的线程id："+Thread.currentThread().getId());
            //handlerofthreadname.setText("UI线程的线程name："+Thread.currentThread().getName());;
            try{   
                Thread.sleep(10000);    //让线程休眠10秒   
            }catch(InterruptedException e){   
                e.printStackTrace();   
            }   
        }   
    };   
}  
