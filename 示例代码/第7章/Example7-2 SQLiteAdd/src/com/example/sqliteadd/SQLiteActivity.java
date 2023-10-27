package com.example.sqliteadd;
import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class SQLiteActivity extends Activity {
    EditText etpname;
    EditText etpprice;
    MyDBOpen mydb;
    Button btn1;
    SQLiteDatabase db;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite);
		etpname=(EditText)findViewById(R.id.etpname);
		etpprice=(EditText)findViewById(R.id.etpprice);
		mydb=new MyDBOpen(this, "shop.db", null, 1);
		btn1=(Button)findViewById(R.id.btn1);
		btn1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			db=mydb.getWritableDatabase();	//创建好数据库
			String pname=etpname.getText().toString();
			String pprice=etpprice.getText().toString();
			int price=Integer.valueOf(pprice);
			db.execSQL("insert into product(pname,pprice) values('"+
			pname+"',"+price+")");
			db.close();
			}
		});
	}
}
