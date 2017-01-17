package com.example.rajat.myapplication;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment {

    public static AlertDialogFragment newInstance()
    {
        return new AlertDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Inspired by the works of artists such as Piet Mondrian and Ben Nicholson.\n\nClick below to learn more!")
                .setCancelable(false)
                .setPositiveButton("Visit MOMA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.moma.org"));
                        Intent chooserIntent = Intent.createChooser(intent,"Choose:");
                        startActivity(chooserIntent);
                    }
                })
                .setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}