package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;

// ActionBarSherlock stuff
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

// Java standard library stuff
import java.io.File;

// My stuff
import com.jaylecavalier.chessvisionplus.R;

public class SquareNamesSettingsActivity extends SherlockFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.squarenamessettings);
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
        ab.setTitle(R.string.square_names_settings);
    }

    public void clearScores(View view) {
    
        // Add a message telling the user that the scores were deleted.
        final AlertDialog.Builder confirm_builder = new AlertDialog.Builder(this);
        confirm_builder.setTitle(R.string.clear_scores_confirm_title);
        confirm_builder.setMessage(R.string.clear_scores_confirm);
        confirm_builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Do nothing
            } 
        });
    
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.clear_scores_title);
        builder.setMessage(R.string.clear_scores_message);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    File f = new File(getApplicationContext().getFilesDir(), "user_best_score.dat");
                    f.delete();
                    // Show the confirmation message
                    AlertDialog confirm_dialog = confirm_builder.create();
                    confirm_dialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Do nothing
            }
        });    
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}