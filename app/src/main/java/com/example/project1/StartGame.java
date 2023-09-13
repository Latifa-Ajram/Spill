package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StartGame extends AppCompatActivity {

    String[] math_questions;
    String[] math_answers;

    TextView editTextAnswer, textViewQuestion;

    ArrayList<Integer> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

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

                if (questions.size() == 0) {
                    textViewQuestion.setText("no more to answer.");
                    return;
                }
                int cQuestionInd = questions.get(questions.size() - 1);
                String ans = editTextAnswer.getText().toString();
                String correctAns = math_answers[cQuestionInd];
                if (ans.equals(correctAns)) {
                    textViewQuestion.setText("Correct!");
                } else {
                    textViewQuestion.setText("Incorrect!!");
                }
            }


        });

      /*
        int randomIndex = new Random().nextInt(math_questions.length);
        newArray[randomIndex] = math_questions[randomIndex];
        textViewQuestion.setText(math_questions[randomIndex]);*/
        Button nextButton = findViewById(R.id.buttonNext);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton(editTextAnswer);

                if (questions.size() == math_answers.length) {

                        textViewQuestion.setText("You have answered all questions");

                       /*int randomIndex = new Random().nextInt(math_questions.length);
                        newArray[randomIndex] = math_questions[randomIndex];
                        textViewQuestion.setText(math_questions[randomIndex]);*/
                    } else {
                        randomQuestion();
                    }


            }
        });


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

        public void two (View view){
            printAns("2");
        }

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