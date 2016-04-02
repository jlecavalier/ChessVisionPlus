package com.jaylecavalier.chessvisionplus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.jaylecavalier.chessvisionplus.R;

public class PushMeDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// We generate a dialog using the convenient Builder class
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.dialog_push_me)
			   .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			   		public void onClick(DialogInterface dialog, int id) {
			   			// CLICKED OK
			   		}
			   })
			   .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
			   		public void onClick(DialogInterface dialog, int id) {
			   			// CLICKED CANCEL
			   		}
			   });
		// Create the AlertDialog object and return it
		return builder.create();
	}
}