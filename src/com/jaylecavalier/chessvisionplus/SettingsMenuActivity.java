package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// ActionBarSherlock stuff
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// My stuff
import com.jaylecavalier.chessvisionplus.R;

public class SettingsMenuActivity extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingsmenu);
	}

	public void startSquareNamesSettings(View view) {
		// Start an intent for the square names settings
		Intent squareNamesSettings = new Intent(getApplicationContext(), SquareNamesSettingsActivity.class);
		// Start the square names settings
		startActivity(squareNamesSettings);
	}
}