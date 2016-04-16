package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

// ActionBarSherlock stuff
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// Java standard library stuff
import java.io.File;

// My stuff
import com.jaylecavalier.chessvisionplus.R;

public class SquareNamesSettingsActivity extends SherlockFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.squarenamessettings);
	}

	public void clearScores(View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.clear_scores_title);
		builder.setMessage(R.string.clear_scores_message);
		builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				try {
					File f = new File(getApplicationContext().getFilesDir(), "user_best_score.dat");
					f.delete();
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