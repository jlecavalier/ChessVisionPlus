package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;

// ActionBarSherlock stuff
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

// My stuff
import com.jaylecavalier.chessvisionplus.R;

public class MainMenuActivity extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		setupActionBar();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    		// Respond to the action bar's Up/Home button
    		case android.R.id.home:
        		NavUtils.navigateUpFromSameTask(this);
        		return true;
    	}
    	return super.onOptionsItemSelected(item);
	}

	private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setTitle(R.string.app_name);
    }

	public void startSquareNames(View view) {
		// Start an intent for the square names game
		Intent squareNamesActivity = new Intent(getApplicationContext(), SquareNamesActivity.class);
		// Start the square names game
		startActivity(squareNamesActivity);
	}

	public void startSettings(View view) {
		// Start an intent for the settings menu
		Intent settingsMenuActivity = new Intent(getApplicationContext(), SettingsMenuActivity.class);
		// Start the settings menu
		startActivity(settingsMenuActivity);
	}
        
        public void startBasicKnightSight(View view) {
            // Start an intent for the Basic Knight Sight game
            Intent basicKnightSightActivity = new Intent(getApplicationContext(), BasicKnightSightActivity.class);
            // start the Basic Knight Sight game
            startActivity(basicKnightSightActivity);
        }

}