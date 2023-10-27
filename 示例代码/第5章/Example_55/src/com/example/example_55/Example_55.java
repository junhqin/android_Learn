package com.example.example_55;

import com.example.example_55.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ToggleButton;

public class Example_55 extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
		toggleButton.setChecked(true);
		
	}
}