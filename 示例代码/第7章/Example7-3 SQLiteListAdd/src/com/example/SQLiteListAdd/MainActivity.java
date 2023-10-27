package com.example.SQLiteListAdd;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
public class MainActivity extends ListActivity {
    SqliteOpen mydb;
    Context context=this;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mydb=new SqliteOpen(this, "user0.db", null, 1);
		show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(1, 1, 1, "����").setIcon(R.drawable.ic_launcher);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	    if(item.getItemId()==1)
	    {
	    	Intent in=new Intent();
	    	in.setClass(this, AddActivity.class);
	    	startActivity(in);
	    }
		return super.onMenuItemSelected(featureId, item);
	}
	public void show()
	/*
	 * 1���õ�һ���ɶ�DB
	 * 2����ѯ��õ�Cursor
	 * 3�����α������arrayList<HashMap<String,Object>> 
	 * 4������simpleAdapter
	 * 5����adpter����LsitView��
	 * 
	 */
	{
		
	    SQLiteDatabase db=mydb.getReadableDatabase();
	    Cursor cur=db.query("user", new String[]{"uid","uname","uage"}, "", null, null, null, null);
	    ArrayList< HashMap<String, Object>> ulist=new ArrayList<HashMap<String,Object>>();
	    while(cur.moveToNext())
	    {
           HashMap<String, Object> hm=new HashMap<String, Object>();
           hm.put("uid", cur.getInt(0));
           hm.put("uname", cur.getString(1));
           hm.put("uage", cur.getInt(2));
           ulist.add(hm);
	    }
	    SimpleAdapter adp=new SimpleAdapter(this, ulist, R.layout.list, new String[]{"uid","uname","uage"}, 
	    		new int[]{R.id.uid,R.id.uname,R.id.uage});
	    this.getListView().setAdapter(adp);    
	}
}
