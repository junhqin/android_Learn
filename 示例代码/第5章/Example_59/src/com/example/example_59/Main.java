package com.example.example_59;

import com.example.example_59.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

public class Main extends TabActivity implements OnClickListener
{

	@Override
	public void onClick(View view)
	{
		// getTabHost().setCurrentTab(2);
		getTabHost().setCurrentTabByTag("tab3");
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();

		/*
		 * LayoutInflater.from(this).inflate(R.layout.main,
		 * tabHost.getTabContentView(), true);
		 */
		LayoutInflater.from(this).inflate(R.layout.main,
				tabHost.getTabContentView(), true);
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("�л���ǩ")
				.setContent(R.id.button));
		tabHost.addTab(tabHost
				.newTabSpec("tab2")
				.setIndicator("���",
						getResources().getDrawable(R.drawable.icon1))
				.setContent(new Intent(this, GalleryActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("����")
				.setContent(new Intent(this, RatingListView.class)));

		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(this);
	}
}