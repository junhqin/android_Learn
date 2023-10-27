package org.synu.sqlitecreate;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class MainActivity extends Activity {
    Button btn;
    MySqliteDB mydb;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mydb=new MySqliteDB(this, "MyDB", null, 1);
		btn=(Button)findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				SQLiteDatabase db=mydb.getReadableDatabase();
			}
		});
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
