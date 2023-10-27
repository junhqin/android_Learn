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
	private Button sendStaticButton;	//���;�̬ע��㲥�İ�ť
	private Button sendDynamicButton;	//���Ͷ�̬ע��㲥�İ�ť
	private static final String STATICACTION = "com.lth.staticreceiver";		//��̬�㲥��Action�ַ���
	private static final String DYNAMICACTION = "com.lth.dynamicreceiver";	//��̬�㲥��Action�ַ���
	
	private dynamicReceiver dy_receiver;  //���嶯̬�㲥����������
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendStaticButton = (Button) findViewById(R.id.send_static);		//��ȡButton��ť����
		sendDynamicButton = (Button) findViewById(R.id.send_dynamic);
		sendStaticButton.setOnClickListener(new DIYOnClickListener());	//ΪButton��ť��Ӽ�����
		sendDynamicButton.setOnClickListener(new DIYOnClickListener());
		
		
		//��togglebutton�Զ�̬�㲥����������ע������ע��
	    ToggleButton tbBindService=(ToggleButton)findViewById(R.id.register);
	    tbBindService.setOnCheckedChangeListener
	    (
	    	new OnCheckedChangeListener()
	    	{
				@Override
				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
				{
					if(isChecked)
					{//�Ѿ�ѡ�У���̬ע��㲥��������
						dy_receiver=new dynamicReceiver();       //����Ҫ��̬ע��Ĺ㲥���󣬴˾�ز�����
						IntentFilter dynamic_filter = new IntentFilter();  //����Intent������
						dynamic_filter.addAction(DYNAMICACTION);			//��Ӷ�̬�㲥��Action
						registerReceiver(dy_receiver, dynamic_filter);	// ע���Զ��嶯̬�㲥��Ϣ
					}
					else
					{//�����̬ע��㲥������
						unregisterReceiver(dy_receiver);
					}
				}
	    	}
	    );
	}
	class DIYOnClickListener implements OnClickListener{		//�ڲ���OnClick������
		public void onClick(View v) {
			if(v.getId() == R.id.send_static){		// �����Զ��徲̬ע��㲥��Ϣ
				Intent intent = new Intent();
				intent.setAction(STATICACTION);		//����Action
				intent.putExtra("msg", "��̬���͵Ĺ㲥��");	//��Ӹ�����Ϣ
				sendBroadcast(intent);				//����Intent
			}
			else if(v.getId() == R.id.send_dynamic){	// �����Զ��嶯̬ע��㲥��Ϣ
				Intent intent = new Intent();
				intent.setAction(DYNAMICACTION);		//����Action
				intent.putExtra("msg", "��̬���͵Ĺ㲥��");		//��Ӹ�����Ϣ
				sendBroadcast(intent);					//����Intent
	}}}
}
