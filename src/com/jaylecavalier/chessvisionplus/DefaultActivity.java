package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.DialogFragment;

// ActionBarSherlock stuff
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// My stuff
import com.jaylecavalier.chessvisionplus.R;
import com.jaylecavalier.chessvisionplus.PushMeDialogFragment;

public class DefaultActivity extends SherlockFragmentActivity {
	/**
	 * Called when the activity is first created.
	*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	// Called when the button that says "push me" is clicked
	public void pushMe(View view) {
		// Handle for the dialog
		DialogFragment dialog = new PushMeDialogFragment();
		// Show the dialog to the user, since the button was pressed.
		dialog.show(getSupportFragmentManager(), "pushme");
	}
}