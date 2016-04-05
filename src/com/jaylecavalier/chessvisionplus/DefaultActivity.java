package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.DialogFragment;
import android.widget.GridView;
import android.widget.TextView;

// ActionBarSherlock stuff
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// My stuff
import com.jaylecavalier.chessvisionplus.R;
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

    	// Get a handle for the Ubuntu font
		Typeface ubuntuReg = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu-R.ttf");

		// Set the font for the "last square tapped" text
    	TextView last_square = (TextView) findViewById(R.id.last_square_tapped);
    	last_square.setTypeface(ubuntuReg);

    	// Set the font for the square name text
    	TextView square_name = (TextView) findViewById(R.id.square_name);
    	square_name.setTypeface(ubuntuReg);
    }

    // Updates the text revealing the name of the last square tapped
    public void updateSquareName(String name) {
    	// Handle for the square name text
    	TextView square_name = (TextView) findViewById(R.id.square_name);
    	// set the text to the given name
    	square_name.setText(name);
    }
}