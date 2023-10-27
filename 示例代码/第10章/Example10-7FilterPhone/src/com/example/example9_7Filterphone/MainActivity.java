package com.example.example9_7Filterphone;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override 
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);
        MyPhoneStateListener myPSListener=new MyPhoneStateListener();
        TelephonyManager tmanager=(TelephonyManager)this.getSystemService(TELEPHONY_SERVICE);
        tmanager.listen(myPSListener, MyPhoneStateListener.LISTEN_CALL_STATE);
    }
    public class MyPhoneStateListener extends PhoneStateListener
    {
    	public void onCallStateChanged (int state, String incomingNumber)
    	{
    		switch(state)
    		{
	    		case TelephonyManager.CALL_STATE_IDLE://待机
	    			Toast.makeText(MainActivity.this, "电话过滤程序启动", Toast.LENGTH_LONG).show();
	    		break; 
	    		case TelephonyManager.CALL_STATE_OFFHOOK://通话中
	    			Toast.makeText(MainActivity.this, "通话中", Toast.LENGTH_LONG).show();
	        	break;
	    		case TelephonyManager.CALL_STATE_RINGING://来电 
	    			if(incomingNumber.equals("15555215556"))
	    			{
	    				Toast.makeText(MainActivity.this, "黑名单来电", Toast.LENGTH_LONG).show();
	    			}
	    			else 
	    			{
	    				Toast.makeText(MainActivity.this, "当前手机为来电状态", Toast.LENGTH_LONG).show();
	    			}
	        	break;
    		}
    	}
    }
}
