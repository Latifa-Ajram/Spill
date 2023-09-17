package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Omspill extends AppCompatActivity {

    TextView omspill;
    TextView regler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omspill);

        regler = findViewById(R.id.textViewRegel);
        omspill = findViewById(R.id.textViewOmspill);


                regler.setText("Hvordan bruke spillet");

                String om = " " +
                        "I dette spillet får du opp 5 tilfeldige regnestykker , skriv svaret ditt på " +
                        "feltet og trykk 'ok' du vil få en tilbakemelding om ditt svar var korrekt eller ikke." +
                        "trykk 'next' for å fortsette spillet ,når alle regenstykkene er besvart vil du få beskjed om det." +
                        "For å endre antall spørsmål trykk på 'Preferanser', samt kan du endre språk til tysk ";
                omspill.setText(" "+ om);


    }

}
