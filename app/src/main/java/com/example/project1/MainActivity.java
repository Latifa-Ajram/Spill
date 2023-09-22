package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project1.R;
import com.example.project1.StartGame;
import com.example.project1.Preferanse;

public class MainActivity extends AppCompatActivity {

    Button start;
    Button omspill;
    Button preferanser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.buttonSpill);
        omspill =findViewById(R.id.buttonOmspill);
        preferanser = findViewById(R.id.buttonPreferanser);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, StartGame.class);
                startActivity(intent);

            }
        });


        preferanser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Preferanse.class);
                startActivity(intent);

            }
        });

        omspill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Omspill.class);
                startActivity(intent);

            }
        });


    }
}