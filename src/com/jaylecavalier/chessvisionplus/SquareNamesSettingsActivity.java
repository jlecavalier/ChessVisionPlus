package com.jaylecavalier.chessvisionplus;

// Android stuff
import android.os.Bundle;
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
		try {
			File f = new File(getApplicationContext().getFilesDir(), "user_best_score.dat");
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}