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


                regler.setText(getString(R.string.Hvordan_bruke_spillet));

                omspill.setText(getString(R.string.Hvordan_bruke_spillet_beskrivelse));

        Button AvbrytButton = findViewById(R.id.buttonAvbryt);

        AvbrytButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();


            }
        });

    }

}
