package org.synu.sqlitecreate;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
public class MySqliteDB extends SQLiteOpenHelper {
	public MySqliteDB(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);	
	}
	public void onCreate(SQLiteDatabase db) {
		   db.execSQL("create table if not exists people("+
					"pid integer primary key,"+
					"pname text,"+
					"page integer)"
					);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {	
	}
}
