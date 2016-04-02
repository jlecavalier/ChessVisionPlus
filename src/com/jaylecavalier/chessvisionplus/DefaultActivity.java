package com.jaylecavalier.chessvisionplus;

import android.app.Activity;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.jaylecavalier.chessvisionplus.R;

public class DefaultActivity extends SherlockFragmentActivity {
	/**
	 * Called when the activity is first created.
	*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
}