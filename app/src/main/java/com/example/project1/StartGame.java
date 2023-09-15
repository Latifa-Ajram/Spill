package com.example.project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StartGame extends AppCompatActivity implements MinDialog.MittInterface {

    String[] math_questions;
    String[] math_answers;

    TextView editTextAnswer, textViewQuestion;

    ArrayList<Integer> questions;

    @Override
    public void onYesClick() {
        finish();
    }
    @Override
    public void onNoClick() {
        return;
    }

    public void visDialog(View v)
    {
        DialogFragment dialog = new MinDialog();
        dialog.show(getSupportFragmentManager(),"Tittel");
    }
    public void svarDialog(View v)
    {
        DialogFragment dialog = new MinDialog();
        dialog.show(getSupportFragmentManager(),"SvarDialog");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        SharedPreferences sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE);

// Retrieve the number using the same key
        int receivedNumber = sharedPreferences.getInt("antall", 5);

        editTextAnswer = findViewById(R.id.editTextAnswer);
        textViewQuestion = findViewById(R.id.textViewQuestion);

        Resources res = getResources();

        math_questions = res.getStringArray(R.array.math_questions);
        math_answers = res.getStringArray(R.array.math_answers);

        questions = new ArrayList<>();
        randomQuestion();

        Button okButton = findViewById(R.id.buttonOk);

        okButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if (questions.size() != 0 && questions.size() != receivedNumber) {
                    int cQuestionInd = questions.get(questions.size() - 1);
                    String ans = editTextAnswer.getText().toString();
                    String correctAns = math_answers[cQuestionInd];
                    if (ans.equals(correctAns)) {
                        svarDialog(view);
                        textViewQuestion.setText("Congratulations. Your Answer is True.");

                    } else {
                        svarDialog(view);
                        textViewQuestion.setText("Sorry! Your Answer is Wrong!");
                    }

                }

                else { textViewQuestion.setText("no more Questions to answer!");}

            }


        });


        Button nextButton = findViewById(R.id.buttonNext);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton(editTextAnswer);

                if (questions.size() == receivedNumber) {

                    textViewQuestion.setText("You have answered all questions, go to the main screen");


                    } else {
                        randomQuestion();

                    }


            }
        });



        Button AvbrytButton = findViewById(R.id.buttonAvbryt);

        AvbrytButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions.size() != receivedNumber ) {

                    visDialog(view);

                    /*
                    // Hvis det er ubesvarte spørsmål, vis en dialogboks.
                    AlertDialog.Builder builder = new AlertDialog.Builder(StartGame.this);
                    builder.setMessage("Er du sikker på at du vil avslutte spillet?")
                            .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // Avslutt spillet hvis brukeren bekrefter.
                                    finish();
                                }
                            })
                            .setNegativeButton("Nei", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // Lukk dialogboksen hvis brukeren velger "Nei".
                                    dialogInterface.cancel();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();*/
                }

                if(questions.size() == receivedNumber)
                {
                    finish();
                }

            }
        });
/*
        Button knapp2 = findViewById(R.id.button2);
        Intent i = new Intent(this, MainActivity.class);
        knapp2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                startActivity(i);
                finish();
            }
        });
*/
    }

        void randomQuestion () {
            int randInd;
            do {
                randInd = new Random().nextInt(math_questions.length);
            } while (questions.contains(randInd));

            questions.add(randInd);

            textViewQuestion.setText(math_questions[randInd]);

        }


        void printAns (String a){
            String text = editTextAnswer.getText().toString();
            editTextAnswer.setText(text + a);
        }
        public void one (View view){
            printAns("1");
        }

        public void two (View view) { printAns("2"); }

        public void three (View view){
            printAns("3");
        }

        public void four (View view){
            printAns("4");
        }

        public void five (View view){
            printAns("5");
        }

        public void six (View view){
            printAns("6");
        }

        public void seven (View view){
            printAns("7");
        }

        public void eight (View view){
            printAns("8");
        }

        public void nine (View view){
            printAns("9");
        }

        public void zero (View view){
            printAns("0");
        }


        public void clearButton (View view){
            editTextAnswer.setText("");

        }

}