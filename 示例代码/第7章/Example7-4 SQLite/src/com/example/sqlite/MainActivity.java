package com.example.sqlite;

import java.util.HashMap;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	MydbOpen mydb;
	Context context = this;
	EditText unet;
	EditText uaget;
	EditText unetupd;
	EditText uagetupd;
	EditText unet_search;
	String uid;
	View view;
	View updView;
	View searchView;
    private int itemId1=Menu.FIRST;
    private int itemId2=Menu.FIRST+1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mydb=new MydbOpen(context, "user.db", null, 1);
        showList("select * from users");
        registerForContextMenu(getListView());
        getListView().setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> views, View arg1,
					int p, long arg3) {
				HashMap<String, Object> hm= (HashMap<String, Object>)views.getItemAtPosition(p);
				uid=hm.get("uid").toString();
				return false;
			}
		});
	}
public void showList(String sql)
{
	SimpleAdapter adp=new SimpleAdapter(context,mydb.showUserList(sql, null),
			R.layout.list, new String[]{"uid","uname","uage"}, new int[]{R.id.uidtv,R.id.unametv,R.id.uagetv});
	getListView().setAdapter(adp);
}
	public boolean onContextItemSelected(MenuItem item) {
		if(item.getItemId()==itemId1)
		{	
			AlertDialog.Builder builder=new Builder(context);
			LayoutInflater inf=getLayoutInflater();
			updView=inf.inflate(R.layout.update, (ViewGroup)findViewById(R.id.updlayout));
			builder.setView(updView);	
			builder.setTitle("修改用户");
			Cursor cur=mydb.getReadableDatabase().rawQuery("select * from users where uid=?", new String[]{uid});
			cur.moveToNext();
			String name=cur.getString(1);
			String age=cur.getString(2);
			unetupd=(EditText)updView.findViewById(R.id.unetupd);
			uagetupd=(EditText)updView.findViewById(R.id.uagetupd);
			unetupd.setText(name);
			uagetupd.setText(age);
			builder.setPositiveButton("修改", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					unetupd=(EditText)updView.findViewById(R.id.unetupd);
					uagetupd=(EditText)updView.findViewById(R.id.uagetupd);
					String un=unetupd.getText().toString();
					String uage=uagetupd.getText().toString();
					String sql="update users set uname=?,uage=? where uid=?";
					mydb.executeSql(sql, new String[]{un,uage,uid});
					showList("select * from users");
				}
			});
			builder.setNegativeButton("取消", null);
			builder.create().show();
		}
		
		else if(item.getItemId()==itemId2)
		{
			String sql="delete from users where uid=?";
			mydb.executeSql(sql, new String[]{uid});
			showList("select * from users");
		}
		return super.onContextItemSelected(item);
	}
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(0, itemId1, 0, "修改");
		menu.add(0, itemId2, 0, "删除");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(1, 99, 1, "添加");
		menu.add(1, 98, 2, "查询");
		return super.onCreateOptionsMenu(menu);
	}
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item.getItemId()==99)
		{
			AlertDialog.Builder builder=new Builder(context);
			LayoutInflater inf=getLayoutInflater();
			view=inf.inflate(R.layout.add, (ViewGroup)findViewById(R.id.mylayout));
			builder.setView(view);	
			builder.setTitle("添加新用户");
			builder.setPositiveButton("添加", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					unet=(EditText)view.findViewById(R.id.unet);
					uaget=(EditText)view.findViewById(R.id.uaget);
					String un=unet.getText().toString();
					String uage=uaget.getText().toString();
					String sql="insert into users(uname,uage) values(?,?)";
					mydb.executeSql(sql, new String[]{un,uage});
					showList("select * from users");
				}
			});
			builder.setNegativeButton("取消", null);
			builder.create().show();
		}
		else if(item.getItemId()==98)
		{
			AlertDialog.Builder builder=new Builder(context);
			LayoutInflater inf=getLayoutInflater();
			searchView=inf.inflate(R.layout.search, (ViewGroup)findViewById(R.id.searchlayout));
			builder.setView(searchView);	
			builder.setTitle("查询用户");
			builder.setPositiveButton("查询", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					unet_search=(EditText)searchView.findViewById(R.id.unet_search);
					String un=unet_search.getText().toString();
					//String sql="select * from users where uname like '%"+un+"%'";
					String sql="select * from users where uname='"+un+"'";
					showList(sql);
				}
			});
			builder.setNegativeButton("取消", null);
			builder.create().show();
		}
		return super.onMenuItemSelected(featureId, item);
	}
}
