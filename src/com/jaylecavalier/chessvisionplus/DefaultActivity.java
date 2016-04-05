package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.DialogFragment;
import android.widget.GridView;

// ActionBarSherlock stuff
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// My stuff
import com.jaylecavalier.chessvisionplus.R;
import com.jaylecavalier.chessvisionplus.PushMeDialogFragment;
import com.jaylecavalier.chessvisionplus.BoardAdapter;

public class DefaultActivity extends SherlockFragmentActivity {
	/**
	 * Called when the activity is first created.
	*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Get the gridview containing the board
		GridView board = (GridView) findViewById(R.id.board);
		// Set the adapter for the board to our custom BoardAdapter class
    	board.setAdapter(new BoardAdapter(this));
	}
}