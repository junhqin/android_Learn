package com.godxj.fragments.fragmentsview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity implements DetailFragment.OnItemButtonClickListener{

	private DetailFragment df;
	private boolean flag = false;
	private ImageView iv;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FragmentManager fm = getSupportFragmentManager();
		df = (DetailFragment) fm.findFragmentById(R.id.details_fragment);
		df = new DetailFragment();
		FragmentTransaction ft = fm.beginTransaction();
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.replace(R.id.details_fragment, df);
		ft.commit();
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.all);
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!flag){
					btn.setBackgroundResource(R.drawable.help);
					flag = true;
				}else{
					btn.setBackgroundResource(R.drawable.all);
					flag = false;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemViewClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			btn = (Button) v;
			if(!flag){
				iv.setImageResource(R.drawable.help);
				flag = true;
			}else{
				iv.setImageResource(R.drawable.all);
				flag = false;
			}
			break;

		default:
			break;
		}
	}


}
