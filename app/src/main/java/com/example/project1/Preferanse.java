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
    String valgtspraak="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferanse);

        antallSp = findViewById(R.id.antallSp);
        Button button5 = findViewById(R.id.button5);
        Button button10 = findViewById(R.id.button10);
        Button button15 = findViewById(R.id.button15);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                antallSp.setText("5");
                SetPref();

            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                antallSp.setText("10");
                SetPref();

            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                antallSp.setText("15");
                SetPref();

            }
        });


        Button knappno = findViewById(R.id.knappno);
        knappno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("no-No");
                AppCompatDelegate.setApplicationLocales(appLocale);
                valgtspraak="no-No";
                SetPref();

            }
        });

        Button knappde = findViewById(R.id.knappde);
        knappde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("de-DE");
                AppCompatDelegate.setApplicationLocales(appLocale);
                valgtspraak="de-DE";
                SetPref();
            }
        });


        Button AvbrytButton = findViewById(R.id.buttonAvbryt);

        AvbrytButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();


            }
        });


    }
    public void SetPref() {
        String antallValue = antallSp.getText().toString();


        if (!antallValue.isEmpty()) {
            try {

                int antall = Integer.parseInt(antallValue);


                SharedPreferences sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putInt("antall", antall);
                editor.putString("valgtspraak", valgtspraak);
                editor.apply();
                Log.d("SharedPrefs", "Language set to: " + valgtspraak + ", antall set to: " + antall);
                Toast.makeText(Preferanse.this, "Data Saved", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {

            }
        }
    }


}
