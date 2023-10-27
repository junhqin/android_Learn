package com.example.example5_1optionmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, Menu.FIRST + 1, 3, "保存").setIcon(
                        android.R.drawable.ic_menu_save);
        menu.add(Menu.NONE, Menu.FIRST + 2, 4, "删除").setIcon(
                        android.R.drawable.ic_menu_delete);
        menu.add(Menu.NONE, Menu.FIRST + 3, 2, "编辑").setIcon(
                        android.R.drawable.ic_menu_edit);
        menu.add(Menu.NONE, Menu.FIRST + 4, 5, "添加").setIcon(
                        android.R.drawable.ic_menu_add);
        menu.add(Menu.NONE, Menu.FIRST + 5, 1, "详情").setIcon(
                        android.R.drawable.ic_menu_info_details);
        menu.add(Menu.NONE, Menu.FIRST + 6, 6, "帮助").setIcon(
                        android.R.drawable.ic_menu_help);
        return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch (item.getItemId()) {
         case Menu.FIRST + 1:
                 Toast.makeText(this, "保存菜单事件", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 2:
                 Toast.makeText(this, "删除菜单事件", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 3:
                 Toast.makeText(this, "编辑菜单事件", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 4:
                 Toast.makeText(this, "添加菜单事件", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 5:
                 Toast.makeText(this, "详情菜单事件", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 6:
                 Toast.makeText(this, "帮助菜单事件", Toast.LENGTH_LONG).show();
                 break;
         }

         return false;
	}
	 //选项菜单被关闭事件，菜单被关闭有三种情形，menu按钮被再次点击、back按钮被点击或者用户选择了某一个菜单项
    @Override
    public void onOptionsMenuClosed(Menu menu){
            Toast.makeText(this, "选项菜单关闭", Toast.LENGTH_LONG).show();
    }

    //菜单被显示之前的事件
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
            Toast.makeText(this, "选项菜单显示之前调用的方法", Toast.LENGTH_LONG).show();
            //如果返回false，此方法就把用户点击menu的动作给消费了，onCreateOptionsMenu方法将不会被调用
            
            /* 
             * 这里必须返回true. 
             * 如果返回false,则后面的onCreateOptionsMenu方法将不会被执行,定义的选项菜单也就不会显示出来。 
             */  
            return true;
    }
    
    @Override  
    public boolean onMenuOpened(int featureId, Menu menu) {  
        Toast.makeText(this, "选项菜单打开了"+featureId, Toast.LENGTH_LONG).show();  
          
        /* 
         * 这里必须返回true. 
         * 如果返回false, 
         *  则后面会继续执行onPrepareOptionsMenu方法, 
         *  但之后的onCreateOptionsMenu方法不会执行， 
         *  也就不会显示选项菜单了。 
         */  
        return true;  
    }
    
}
