package com.example.project1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MinDialog extends DialogFragment {
    private MittInterface callback;
    public String tittel;

    public MinDialog(String title) {
        tittel= title;
    }

    public interface MittInterface{
        public void onYesClick();
        public void onNoClick();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try {
        callback=(MittInterface) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException("Kallende klasse må implementere" +
                    "interfacet!");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new
                AlertDialog.Builder(getActivity()).setTitle(tittel).setPositiveButton(R.string.Ja, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                callback.onYesClick();
                            }
                        }).setNegativeButton(R.string.Nei, new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                callback.onNoClick();
                            }
                        })
                .create();
    }




}
