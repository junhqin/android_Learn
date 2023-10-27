package com.example.example5_2contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		TextView tv2=(TextView)findViewById(R.id.tv2);
		this.registerForContextMenu(tv2); //��tv2�ؼ�ע�������Ĳ˵�
	}
	@Override
    public   void  onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
    super .onCreateContextMenu(menu, v, menuInfo);
    //�����˵�����������
    MenuInflater inflator=getMenuInflater();
    //������Դ�ж���Ĳ˵�
    inflator.inflate(R.menu.contextmenu, menu);
    //���������Ĳ˵���ͼ��
    menu.setHeaderIcon(R.drawable.ic_launcher);
    //���������Ĳ˵��ı���
    menu.setHeaderTitle("ContextMenu");
}
}
