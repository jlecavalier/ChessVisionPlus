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

public class MainMenuActivity extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
	}

	public void startSquareNames(View view) {
		// Start an intent for the square names game
		Intent squareNamesActivity = new Intent(getApplicationContext(), SquareNamesActivity.class);
		// Start the square names game
		startActivity(squareNamesActivity);
	}

}