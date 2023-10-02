package com.example.pr_w2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class Dialog extends DialogFragment {
    private String[] multiChoiceItems;
    private AlertDialog alertDialog;
    public Dialog() {
    }

    public Dialog(String[] multipleItems) {
        this.multipleItems = multipleItems;
    }

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final boolean[] checkedItems = new boolean[multipleItems.length]; // to keep track of checked items in dialog

        builder.setTitle("Select Items")
                .setMultipleItems(multipleItems, checkedItems, new DialogInterface.OnMultipleClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    }
                });

        builder.setPositiveButton("OK", null);

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        alertDialog = builder.create();



        return alertDialog;
    }
}