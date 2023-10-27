package com.example.sqlite;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleAdapter;

public class MydbOpen extends SQLiteOpenHelper {
	MydbOpen mydb;
	public MydbOpen(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
	db.execSQL("create table if not exists users(" +
			"uid integer primary key," +
			"uname varchar," +
			"uage integer)");	
	db.execSQL("insert into users(uname,uage) values('tom',21)");
	db.execSQL("insert into users(uname,uage) values('jack',18)");
	db.execSQL("insert into users(uname,uage) values('mary',28)");
	db.execSQL("insert into users(uname,uage) values('Lili',25)");
	}
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
  public void executeSql(String sql,String[] ps)
  {
	  this.getWritableDatabase().execSQL(sql, ps);
  }
  public ArrayList< HashMap<String, Object>> showUserList(String sql,String[] ps)
  {
	  ArrayList< HashMap<String, Object>> ulist=new ArrayList<HashMap<String,Object>>();
	  Cursor cur=this.getReadableDatabase().rawQuery(sql, ps);
	  while(cur.moveToNext())
	  {
		  HashMap<String, Object> hm=new HashMap<String, Object>();
		  String uid=cur.getString(0);
		  String uname=cur.getString(1);
		  String uage=cur.getString(2);
		  hm.put("uid", uid);
		  hm.put("uname", uname);
		  hm.put("uage", uage);
		  ulist.add(hm);
	  }
     return ulist;
  }
}