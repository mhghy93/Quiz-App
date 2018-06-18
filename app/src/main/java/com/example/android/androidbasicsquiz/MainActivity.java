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
    private RadioButton questionOneOptionB, questionTwoOptionC, questionThreeOptionC, questionFourOptionB;
    private CheckBox questionFiveOptionA, questionFiveOptionB, questionFiveOptionC, questionFiveOptionD;
    private EditText questionSixAns;
    private int totalScore = 0;

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
        questionFiveOptionC = (CheckBox) findViewById(R.id.q5_optionC);
        questionFiveOptionD = (CheckBox) findViewById(R.id.q5_optionD);
        Boolean answerFiveChoiceOne = questionFiveOptionA.isChecked();
        Boolean answerFiveChoiceTwo = questionFiveOptionB.isChecked();
        Boolean answerFiveChoiceThree = questionFiveOptionC.isChecked();
        Boolean answerFiveChoiceFour = questionFiveOptionD.isChecked();
        checkDoubleChoiceAnswer(answerFiveChoiceOne, answerFiveChoiceTwo, answerFiveChoiceThree, answerFiveChoiceFour);

        questionSixAns = (EditText) findViewById(R.id.inp_ans6);
        String answerSix = questionSixAns.getText().toString().toLowerCase();
        checkTypedAnswer(answerSix);

        if (totalScore == 30) {
            Toast.makeText(MainActivity.this, "Congratulations!You answered all the questions correctly.You scored: 30 out of 30", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "You scored: " + totalScore + " out of 30", Toast.LENGTH_LONG).show();
        }

        totalScore = 0;
    }


    public void checkSingleChoiceAnswer(Boolean answer) {
        if (answer) {
            totalScore += 5;
        }
    }


    public void checkDoubleChoiceAnswer(Boolean answerOne, Boolean answerTwo, Boolean answerThree, Boolean answerFour) {
        if (answerOne && answerTwo && !answerThree && !answerFour) {
            totalScore += 5;
        }
    }


    public void checkTypedAnswer(String answer) {
        if (answer.equalsIgnoreCase("eight")) {
            totalScore += 5;
        }
    }

    public void reset(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
