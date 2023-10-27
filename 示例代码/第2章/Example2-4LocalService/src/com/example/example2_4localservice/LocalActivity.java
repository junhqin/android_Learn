package com.example.example2_4localservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LocalActivity extends Activity {

	private Intent mIntent=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local);
		Button bt_start=(Button)findViewById(R.id.start);
		Button bt_stop=(Button)findViewById(R.id.stop);
		bt_start.setOnClickListener(new Myclicklistener());
		bt_stop.setOnClickListener(new Myclicklistener());
		
	}
    class Myclicklistener implements OnClickListener{
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		switch (v.getId()) {
			case R.id.start:
				doStart();
				break;

			case R.id.stop:
				doStop();
				break;
			}
    	}
     }
    private void doStart(){
    	this.mIntent=new Intent(LocalActivity.this,LocalService.class);
    	this.startService(this.mIntent);

    }
	private void doStop(){
		if(this.mIntent!=null){
			this.stopService(this.mIntent);
    //只有调用本方法，当前服务才会停止，和调用本service的LocalActivity是否消亡无关。
		}
	}
}
