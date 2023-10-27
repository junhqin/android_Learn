package com.example.SQLiteListAdd;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteOpen extends SQLiteOpenHelper {

	public SqliteOpen(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists user(" +
				"uid integer primary key," +
				"uname varchar," +
				"uage integer" +
				")");
		db.execSQL("insert into user(uname,uage) values('tom',21)");
		db.execSQL("insert into user(uname,uage) values('jerry',18)");
		db.execSQL("insert into user(uname,uage) values('Mary',25)");
		db.execSQL("insert into user(uname,uage) values('Lucy',19)");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
}
