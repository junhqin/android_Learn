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
		this.registerForContextMenu(tv); //给tv控件注册上下文菜单
		Button mybutton=(Button)findViewById(R.id.button1);
		mybutton.setOnClickListener(new Btonclicklistener());//给按钮加载监听器
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
    menu.add(0,0,Menu.NONE, "发送" ); //添加一个标题为update的菜单项
    menu.add(0,1,Menu.NONE, "标记为重要" ); //添加一个标题为insert的菜单项
    menu.add(0,2,Menu.NONE, "重命名" ); //添加一个标题为delete的菜单项
    menu.add(0,3,Menu.NONE, "删除" ); //添加一个标题为query的菜单项
   }
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	switch (item.getItemId()){
	  case  0 : 
		 Toast.makeText(this, "发送事件", Toast.LENGTH_LONG).show();
	     break ;
	  case  1 : 
		 Toast.makeText(this, "标记为重要事件", Toast.LENGTH_LONG).show();
	     break ;
	  case  2 : 
		 Toast.makeText(this, "重命名事件", Toast.LENGTH_LONG).show();
	     break ;
	  case  3 : 
		 Toast.makeText(this, "删除事件", Toast.LENGTH_LONG).show();
	     break ;
	}
	return   super.onContextItemSelected(item);
	}
}
