package com.example.example5_2contextmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv=(TextView)findViewById(R.id.tv);
		this.registerForContextMenu(tv); //��tv�ؼ�ע�������Ĳ˵�
		Button mybutton=(Button)findViewById(R.id.button1);
		mybutton.setOnClickListener(new Btonclicklistener());//����ť���ؼ�����
	}
    class Btonclicklistener implements OnClickListener{
    	@Override
    	public void onClick(View v) {
    		Intent intent=new Intent();
    		intent.setClass(MainActivity.this, SecondActivity.class);
    		MainActivity.this.startActivity(intent);	
    	}
    }
	@Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
    super .onCreateContextMenu(menu, v, menuInfo);
    menu.add(0,0,Menu.NONE, "����" ); //���һ������Ϊupdate�Ĳ˵���
    menu.add(0,1,Menu.NONE, "���Ϊ��Ҫ" ); //���һ������Ϊinsert�Ĳ˵���
    menu.add(0,2,Menu.NONE, "������" ); //���һ������Ϊdelete�Ĳ˵���
    menu.add(0,3,Menu.NONE, "ɾ��" ); //���һ������Ϊquery�Ĳ˵���
   }
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	switch (item.getItemId()){
	  case  0 : 
		 Toast.makeText(this, "�����¼�", Toast.LENGTH_LONG).show();
	     break ;
	  case  1 : 
		 Toast.makeText(this, "���Ϊ��Ҫ�¼�", Toast.LENGTH_LONG).show();
	     break ;
	  case  2 : 
		 Toast.makeText(this, "�������¼�", Toast.LENGTH_LONG).show();
	     break ;
	  case  3 : 
		 Toast.makeText(this, "ɾ���¼�", Toast.LENGTH_LONG).show();
	     break ;
	}
	return   super.onContextItemSelected(item);
	}
}
