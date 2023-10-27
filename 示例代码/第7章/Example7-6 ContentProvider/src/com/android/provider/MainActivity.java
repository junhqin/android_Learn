package com.android.provider;



import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private Uri url = Uri.parse("content://com.android.provider.studentprovider/student");
	private Button btnAdd;
	private Button btnUpdate;
	private Button btnQuery;
	private Button btnDel;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btnDel = (Button) findViewById(R.id.btnDel);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnUpdate = (Button) findViewById(R.id.btnUpdate);
		btnQuery = (Button) findViewById(R.id.btnQuery);
		btnAdd.setOnClickListener(listener);
		btnUpdate.setOnClickListener(listener);
		btnQuery.setOnClickListener(listener);
		btnDel.setOnClickListener(listener);
	}
	private OnClickListener listener = new OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnAdd:
				add();
				break;
			case R.id.btnUpdate:
				update();
				break;
			case R.id.btnQuery:
				query();
				break;
			case R.id.btnDel:
				delete();
				break;
			default:
				break;
			}
		}
	};
	protected void delete() {
		ContentResolver contentResolver = getContentResolver();
		String where = "";
		String[] selectionArgs = null;
		where = "sid in (?,?)";
		selectionArgs = new String[] { "1", "2" };
		contentResolver.delete(url, where, selectionArgs);
	}
	protected void query() {
		ContentResolver contentResolver = getContentResolver();
		String[] projection = new String[] { "sid", "name", "age" };
		String selection = "";
		String[] selectionArgs = null;
		String sortOrder = "";
		Cursor cursor = null;

		selection = "sid < ?";
		selectionArgs = new String[] { "3" };
		cursor = contentResolver.query(url, projection, selection,
				selectionArgs, sortOrder);
		while (cursor.moveToNext()) {
			Log.i(TAG,
					"sid=" + cursor.getInt(0) + "name=" + cursor.getString(1)
							+ "age=" + cursor.getShort(2));
		}
	}
	protected void update() {
		ContentResolver contentResolver = getContentResolver();
		ContentValues values = new ContentValues();
		String where = "";
		String[] selectionArgs = null;
		values.put("name", "Updated");
		values.put("age", "23");
		where = "sid = ?";
		selectionArgs = new String[] { "1" };
		contentResolver.update(url, values, where, selectionArgs);
	}
	protected void add() {
		ContentResolver contentResolver = getContentResolver();
		ContentValues values = new ContentValues();
		values.put("name", "Mark");
		values.put("age", "34");
		Log.i(TAG, contentResolver.insert(url, values).toString());
	}
}