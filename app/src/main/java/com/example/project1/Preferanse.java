package com.example.project1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;




public class Preferanse extends AppCompatActivity {
    TextView antallSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferanse);

        Button knappsv = findViewById(R.id.knappsv);
        knappsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("sv-SV");
                AppCompatDelegate.setApplicationLocales(appLocale);
            }
        });

        Button knappno = findViewById(R.id.knappno);
        knappno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("no-No");
                AppCompatDelegate.setApplicationLocales(appLocale);
            }
        });

        Button knappde = findViewById(R.id.knappde);
        knappde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("de-DE");
                AppCompatDelegate.setApplicationLocales(appLocale);
            }
        });


        Button AvbrytButton = findViewById(R.id.buttonAvbryt);

        AvbrytButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();


            }
        });
        Button prefButton = findViewById(R.id.buttonPref);

        prefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                antallSp = findViewById(R.id.antallSp);
                String antallValue = antallSp.getText().toString();
                if (!antallValue.isEmpty()) {
                    try {

                        int antall = Integer.parseInt(antallValue);


                        SharedPreferences sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putInt("antall", antall);
                        editor.apply();
                        Log.d("SharedPrefs", "antall set to: " + antall);
                        Toast.makeText(Preferanse.this, "Data Saved", Toast.LENGTH_SHORT).show();
                    } catch (NumberFormatException e) {

                    }
                }


            }


        });


    }
}
