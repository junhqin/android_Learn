package com.example.example7_2loopermessage;
import android.os.Handler;
import android.os.Message;

public class MyTaskThread extends Thread {
	private static final int stepTime = 500;			// 每一步执行时间（单位:ms）
	private volatile boolean isEnded;				// 线程是否运行的标记，用于终止线程的运行
	private Handler mainHandler;					// 用于发送消息的处理者
	public static final int MSG_REFRESHINFO = 1;		// 更新界面的消息
	public MyTaskThread(Handler mh)			// 定义构造函数
	{
		super();				// 调用父类的构建器创建对象
		isEnded = false;
		mainHandler = mh;
	}
    @Override
	public void run()		// 在线程体run方法中书写运行代码
	{
        Message msg ;
		for (int i = 0; !isEnded; i++) 
		{
			try {
				Thread.sleep(stepTime);					// 让线程的每一步睡眠指定时间
		        String s = "完成第" + i +"步";
		        msg = new Message();
		        msg.what = MSG_REFRESHINFO;		// 定义消息类型
		        msg.obj = s;							// 给消息附带数据
		        mainHandler.sendMessage(msg);			// 发送消息
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
    public void stopRun()				// 停止线程的运行的控制函数
    {
    	isEnded = true;
    }
}