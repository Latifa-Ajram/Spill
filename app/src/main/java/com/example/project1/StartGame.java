package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;

public class StartGame extends AppCompatActivity {

    String[] math_questions ;
    String[] math_answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Resources res= getResources();

         math_questions = res.getStringArray(R.array.math_questions);
         math_answers = res.getStringArray(R.array.math_answers);

    }
}