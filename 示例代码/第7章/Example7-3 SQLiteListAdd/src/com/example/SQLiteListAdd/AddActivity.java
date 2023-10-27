package com.example.SQLiteListAdd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class AddActivity extends Activity {
    EditText unet;
	EditText uaget;
	Button button1;
	Context context=this;
	SqliteOpen mysql;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		mysql=new SqliteOpen(this, "user0.db", null, 1);
		unet=(EditText)findViewById(R.id.unet);
		uaget=(EditText)findViewById(R.id.uaget);
		button1=(Button)findViewById(R.id.btn);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=unet.getText().toString();
				String age=uaget.getText().toString();
				String sql="insert into user(uname,uage) values('"+name+"',"+age+")";
				SQLiteDatabase db=mysql.getWritableDatabase();
				db.execSQL(sql);
				db.close();
				Toast.makeText(context,"Ìí¼Ó³É¹¦£¡",Toast.LENGTH_SHORT).show();
		    	Intent in=new Intent();
		    	in.setClass(context, MainActivity.class);
		    	startActivity(in);
			}
		});
	}
}
