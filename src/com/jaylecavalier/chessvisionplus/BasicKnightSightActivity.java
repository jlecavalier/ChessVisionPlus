package com.jaylecavalier.chessvisionplus;

import com.jaylecavalier.chessvisionplus.boardadapters.SquareNamesBoardAdapter;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.jaylecavalier.chessvisionplus.boardadapters.BasicKnightSightBoardAdapter;

/**
 *
 * @author jay
 */
public class BasicKnightSightActivity extends SherlockFragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Make sure onCreate does what it's supposed to do OTB
        super.onCreate(savedInstanceState);
        // Tell the device to use the basicknightsight layout for this activity
        setContentView(R.layout.basicknightsight);
        // Set up the action bar
        setupActionBar();
        // Get the gridview containing the board
        GridView board = (GridView) findViewById(R.id.board);
        // Set the adapter for the board to our custom SquareNamesBoardAdapter class
        board.setAdapter(new BasicKnightSightBoardAdapter(this));
        Log.d("Created", "Basic Knight Sight Activity");
    }
    
    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.basic_knight_sight);
    }
    
    // Need this to tell the back button on the action bar what to do
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
    
    public void displayTapped(String tapped, ImageView tapped_square, int tapped_position) {
        // handle to "tapped" text
        TextView tappedView = (TextView) findViewById(R.id.tapped);
        // Set the text to the square the user tapped
        tappedView.setText(tapped);
        Log.d("BKS", tapped + " was tapped!");
    }
    
}
