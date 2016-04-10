package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.support.v4.app.DialogFragment;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

// ActionBarSherlock stuff
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// Java standard library stuff
import java.util.Random;

// My stuff
import com.jaylecavalier.chessvisionplus.R;
import com.jaylecavalier.chessvisionplus.BoardAdapter;

public class DefaultActivity extends SherlockFragmentActivity {

    private int red_pos;
    private int green_pos;

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
    public void checkIfCorrect(String tapped, ImageView tapped_square, int tapped_position) {
    	// handle to target square view
    	TextView square_name = (TextView) findViewById(R.id.square_name);
    	// handle to "answer" text
    	TextView answer = (TextView) findViewById(R.id.answer);
    	// the name of the target square
    	String target = square_name.getText().toString();
    	// User tapped the correct square
    	if (tapped.equals(target)) {
    		answer.setText(R.string.correct);
    		// Green
    		answer.setTextColor(Color.rgb(42,162,42));
    		pickSquare((GridView) findViewById(R.id.board));
    	}
    	// User tapped an incorrect square
    	else {
    		answer.setText(R.string.incorrect);
    		incorrectAnswer(tapped, target, tapped_square, tapped_position);
    		// Red
    		answer.setTextColor(Color.rgb(255,26,26));
    	}
    }

	// Makes the "Next Problem" button visible and clickable
	private void incorrectAnswer(String tapped, String target, ImageView tapped_square, int tapped_position) {
		Button nextProblemButton = (Button) findViewById(R.id.next_problem);
		nextProblemButton.setVisibility(View.VISIBLE);
		nextProblemButton.setClickable(true);
		// Make board unclickable
		GridView board = (GridView) findViewById(R.id.board);
		for(int i=0; i<board.getChildCount(); i++) {
			ImageView child = (ImageView) board.getChildAt(i);
			child.setClickable(false);
		}
		displayCorrectAnswer(tapped, target, tapped_square, tapped_position);
	}

	private void displayCorrectAnswer(String tapped, String target, ImageView tapped_square, int tapped_position) {
		int location[] = new int[2];
		tapped_square.getLocationInWindow(location);
        red_pos = tapped_position;
		tapped_square.setImageResource(R.drawable.redsquare);
		TextView incorrectText = (TextView) findViewById(R.id.incorrect_square);
		RelativeLayout.LayoutParams incorrectParams = (RelativeLayout.LayoutParams) incorrectText.getLayoutParams();
		incorrectText.setText(tapped);
		incorrectParams.bottomMargin = 0;
		incorrectParams.topMargin = location[1] - 315;
		incorrectParams.leftMargin = location[0] + 25;
		incorrectParams.rightMargin = 0;
		incorrectText.setVisibility(View.VISIBLE);
	}

	// Called when the "Next Problem" button is clicked
	// Makes the "Next Problem" button invisible and begins 
	// the next problem
	public void nextProblem(View view) {
		Button nextProblemButton = (Button) findViewById(R.id.next_problem);
		nextProblemButton.setVisibility(View.GONE);
		nextProblemButton.setClickable(false);
		TextView answer = (TextView) findViewById(R.id.answer);
		answer.setText("");
		pickSquare((GridView) findViewById(R.id.board));
		TextView incorrectText = (TextView) findViewById(R.id.incorrect_square);
		incorrectText.setVisibility(View.GONE);
		// Make board clickable again
		GridView board = (GridView) findViewById(R.id.board);
        BoardAdapter board_adapter = (BoardAdapter) board.getAdapter();
        ImageView redsquare = (ImageView) board.getChildAt(red_pos);
        redsquare.setImageResource(board_adapter.getImage(red_pos));
		for(int i=0; i<board.getChildCount(); i++) {
			ImageView child = (ImageView) board.getChildAt(i);
			child.setClickable(true);
		}
	}
}