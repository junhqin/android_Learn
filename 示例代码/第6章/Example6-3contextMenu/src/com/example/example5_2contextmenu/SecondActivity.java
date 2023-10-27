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
		this.registerForContextMenu(tv2); //给tv2控件注册上下文菜单
	}
	@Override
    public   void  onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
    super .onCreateContextMenu(menu, v, menuInfo);
    //创建菜单解析器对象
    MenuInflater inflator=getMenuInflater();
    //解析资源中定义的菜单
    inflator.inflate(R.menu.contextmenu, menu);
    //设置上下文菜单的图标
    menu.setHeaderIcon(R.drawable.ic_launcher);
    //设置上下文菜单的标题
    menu.setHeaderTitle("ContextMenu");
}
}
