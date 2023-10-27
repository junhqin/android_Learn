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
        menu.add(Menu.NONE, Menu.FIRST + 1, 3, "����").setIcon(
                        android.R.drawable.ic_menu_save);
        menu.add(Menu.NONE, Menu.FIRST + 2, 4, "ɾ��").setIcon(
                        android.R.drawable.ic_menu_delete);
        menu.add(Menu.NONE, Menu.FIRST + 3, 2, "�༭").setIcon(
                        android.R.drawable.ic_menu_edit);
        menu.add(Menu.NONE, Menu.FIRST + 4, 5, "���").setIcon(
                        android.R.drawable.ic_menu_add);
        menu.add(Menu.NONE, Menu.FIRST + 5, 1, "����").setIcon(
                        android.R.drawable.ic_menu_info_details);
        menu.add(Menu.NONE, Menu.FIRST + 6, 6, "����").setIcon(
                        android.R.drawable.ic_menu_help);
        return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch (item.getItemId()) {
         case Menu.FIRST + 1:
                 Toast.makeText(this, "����˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 2:
                 Toast.makeText(this, "ɾ���˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 3:
                 Toast.makeText(this, "�༭�˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 4:
                 Toast.makeText(this, "��Ӳ˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 5:
                 Toast.makeText(this, "����˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         case Menu.FIRST + 6:
                 Toast.makeText(this, "�����˵��¼�", Toast.LENGTH_LONG).show();
                 break;
         }

         return false;
	}
	 //ѡ��˵����ر��¼����˵����ر����������Σ�menu��ť���ٴε����back��ť����������û�ѡ����ĳһ���˵���
    @Override
    public void onOptionsMenuClosed(Menu menu){
            Toast.makeText(this, "ѡ��˵��ر�", Toast.LENGTH_LONG).show();
    }

    //�˵�����ʾ֮ǰ���¼�
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
            Toast.makeText(this, "ѡ��˵���ʾ֮ǰ���õķ���", Toast.LENGTH_LONG).show();
            //�������false���˷����Ͱ��û����menu�Ķ����������ˣ�onCreateOptionsMenu���������ᱻ����
            
            /* 
             * ������뷵��true. 
             * �������false,������onCreateOptionsMenu���������ᱻִ��,�����ѡ��˵�Ҳ�Ͳ�����ʾ������ 
             */  
            return true;
    }
    
    @Override  
    public boolean onMenuOpened(int featureId, Menu menu) {  
        Toast.makeText(this, "ѡ��˵�����"+featureId, Toast.LENGTH_LONG).show();  
          
        /* 
         * ������뷵��true. 
         * �������false, 
         *  ���������ִ��onPrepareOptionsMenu����, 
         *  ��֮���onCreateOptionsMenu��������ִ�У� 
         *  Ҳ�Ͳ�����ʾѡ��˵��ˡ� 
         */  
        return true;  
    }
    
}
