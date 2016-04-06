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

// Java standard library stuff
import java.util.Random;

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

    	// Start the game by picking a square for the user
    	pickSquare(board);
    }

    // Sets the fonts of all the text on the screen to the custom Ubuntu font
    // we all love so much :)
    public void setFonts() {
    	// Get a handle for the Ubuntu font
    	Typeface ubuntuReg = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu-R.ttf");

    	// Set the font for the "last square tapped" text
    	TextView last_square = (TextView) findViewById(R.id.tap);
    	last_square.setTypeface(ubuntuReg);

    	// Set the font for the square name text
    	TextView square_name = (TextView) findViewById(R.id.square_name);
    	square_name.setTypeface(ubuntuReg);

    	// Set the font for the answer text
    	TextView answer = (TextView) findViewById(R.id.answer);
    	answer.setTypeface(ubuntuReg);
    }

    // Updates the text revealing the name of the last square tapped
    public void updateSquareName(String name) {
    	// Handle for the square name text
    	TextView square_name = (TextView) findViewById(R.id.square_name);
    	// set the text to the given name
    	square_name.setText(name);
    }

    // Selects a square for the user to tap
    public void pickSquare(GridView board) {
    	// Handle to board adapter. For access to itemIdToCoord()
    	BoardAdapter board_adapter = (BoardAdapter) board.getAdapter();
    	// Pick a random square and get its' algebraic id as a string
    	String square = board_adapter.itemIdToCoord(randInt(0,63));
    	// Update what the user sees
    	updateSquareName(square);
    }

    // Returns a random integer in a given range
    public int randInt(int min, int max) {
    	Random r = new Random(System.currentTimeMillis());
    	return r.nextInt((max - min) + 1) + min;
    }

    // Tells the user whether or not he tapped the correct square
    public void checkIfCorrect(String tapped) {
    	// handle to target square view
    	TextView square_name = (TextView) findViewById(R.id.square_name);
    	// handle to "answer" text
    	TextView answer = (TextView) findViewById(R.id.answer);
    	// the name of the target square
    	String target = square_name.getText().toString();
    	// User tapped the correct square
    	if (tapped.equals(target)) {
    		answer.setText(R.string.correct);
    	}
    	// User tapped an incorrect square
    	else {
    		answer.setText(R.string.incorrect);
    	}
    	// Pick another square
    	pickSquare((GridView) findViewById(R.id.board));
    }
}