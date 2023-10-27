package com.example.example7_2loopermessage;
import android.os.Handler;
import android.os.Message;

public class MyTaskThread extends Thread {
	private static final int stepTime = 500;			// ÿһ��ִ��ʱ�䣨��λ:ms��
	private volatile boolean isEnded;				// �߳��Ƿ����еı�ǣ�������ֹ�̵߳�����
	private Handler mainHandler;					// ���ڷ�����Ϣ�Ĵ�����
	public static final int MSG_REFRESHINFO = 1;		// ���½������Ϣ
	public MyTaskThread(Handler mh)			// ���幹�캯��
	{
		super();				// ���ø���Ĺ�������������
		isEnded = false;
		mainHandler = mh;
	}
    @Override
	public void run()		// ���߳���run��������д���д���
	{
        Message msg ;
		for (int i = 0; !isEnded; i++) 
		{
			try {
				Thread.sleep(stepTime);					// ���̵߳�ÿһ��˯��ָ��ʱ��
		        String s = "��ɵ�" + i +"��";
		        msg = new Message();
		        msg.what = MSG_REFRESHINFO;		// ������Ϣ����
		        msg.obj = s;							// ����Ϣ��������
		        mainHandler.sendMessage(msg);			// ������Ϣ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
    public void stopRun()				// ֹͣ�̵߳����еĿ��ƺ���
    {
    	isEnded = true;
    }
}