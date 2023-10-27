package com.example.sqliteadd;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBOpen extends SQLiteOpenHelper {
	public MyDBOpen(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists product(" +
				"id integer primary key," +
				"pname varchar," +
				"pprice integer)");
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
}
