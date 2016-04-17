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

public class SettingsMenuActivity extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingsmenu);
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
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.settings);
    }

	public void startSquareNamesSettings(View view) {
		// Start an intent for the square names settings
		Intent squareNamesSettings = new Intent(getApplicationContext(), SquareNamesSettingsActivity.class);
		// Start the square names settings
		startActivity(squareNamesSettings);
	}
}