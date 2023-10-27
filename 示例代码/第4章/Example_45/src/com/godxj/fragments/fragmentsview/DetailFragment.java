package com.godxj.fragments.fragmentsview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DetailFragment extends Fragment {

	private Button btn;
	OnItemButtonClickListener buttonClickListener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		buttonClickListener = (OnItemButtonClickListener) activity;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.details, container, false);
		btn = (Button) view.findViewById(R.id.btn1);
		buttonClickListener.onItemViewClick(btn);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				buttonClickListener.onItemViewClick(v);
			}
		});
		return view;
	}
	public interface OnItemButtonClickListener{
		void onItemViewClick(View v);  		
	}
}
