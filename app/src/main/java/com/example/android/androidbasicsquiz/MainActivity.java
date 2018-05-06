package com.example.android.androidbasicsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton questionOneOptionB, questionTwoOptionC, questionThreeOptionC, questionFourOptionB;
    CheckBox questionFiveOptionA, questionFiveOptionB;
    EditText questionSixAns;
    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void result(View view) {
        questionOneOptionB = (RadioButton) findViewById(R.id.q1_optionB);
        Boolean answerOne = questionOneOptionB.isChecked();
        checkSingleChoiceAnswer(answerOne);

        questionTwoOptionC = (RadioButton) findViewById(R.id.q2_optionC);
        Boolean answerTwo = questionTwoOptionC.isChecked();
        checkSingleChoiceAnswer(answerTwo);

        questionThreeOptionC = (RadioButton) findViewById(R.id.q3_optionC);
        Boolean answerThree = questionThreeOptionC.isChecked();
        checkSingleChoiceAnswer(answerThree);

        questionFourOptionB = (RadioButton) findViewById(R.id.q4_optionB);
        Boolean answerFour = questionFourOptionB.isChecked();
        checkSingleChoiceAnswer(answerFour);

        questionFiveOptionA = (CheckBox) findViewById(R.id.q5_optionA);
        questionFiveOptionB = (CheckBox) findViewById(R.id.q5_optionB);
        Boolean answerFiveChoiceOne = questionFiveOptionA.isChecked();
        Boolean answerFiveChoiceTwo = questionFiveOptionB.isChecked();
        checkDoubleChoiceAnswer(answerFiveChoiceOne, answerFiveChoiceTwo);

        questionSixAns = (EditText) findViewById(R.id.inp_ans6);
        String answerSix = questionSixAns.getText().toString().toLowerCase();
        checkTypedAnswer(answerSix);

        Toast.makeText(MainActivity.this, "You scored: " + totalScore + " out of 30", Toast.LENGTH_LONG).show();
    }


    public void checkSingleChoiceAnswer(Boolean answer) {
        if (answer) {
            totalScore += 5;
        }
    }


    public void checkDoubleChoiceAnswer(Boolean answerOne, Boolean answerTwo) {
        if (answerOne && answerTwo) {
            totalScore += 5;
        }
    }


    public void checkTypedAnswer(String answer) {
        if (answer.equals("eight")) {
            totalScore += 5;
        }
    }

    public void reset(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
