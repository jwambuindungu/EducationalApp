package com.example.android.educationalapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Maths extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        addListenerOnButton();
    }


    int totalScore = 0;
    int finalMathsScore = 0;

    // Get the checked checkBoxes in Question 2
    private int checkMathsQuestionTwo() {
        CheckBox multiple_twelve = (CheckBox) findViewById(R.id.twelve_checkbox);
        Boolean TwelveState = multiple_twelve.isChecked();

        CheckBox multiple_thirty = (CheckBox) findViewById(R.id.thirty_checkbox);
        Boolean ThirtyState = multiple_thirty.isChecked();

        CheckBox multiple_forty = (CheckBox) findViewById(R.id.forty_checkbox);
        Boolean FortyState = multiple_forty.isChecked();

        if (TwelveState) {
            // add a mark is 12 is selected
            totalScore ++;
        }

        if (ThirtyState) {
            // add a mark is 36 is selected
            totalScore ++ ;

        }

        if (FortyState) {
            Context context = getApplicationContext();
            CharSequence text = "Forty is not a multiple of 6";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        return totalScore;
    }

    public double checkMathsQuestionFour() {
        EditText Question4Answer = (EditText) findViewById(R.id.fourth_question);
        String correctAnswer = "DIAMETER";
        String resultName = Question4Answer.getText().toString();
        double Comparison = Geography.similarity(resultName, correctAnswer);

        return Comparison;
    }

    public void addListenerOnButton() {

        final RadioGroup radioTwoGroup = (RadioGroup) findViewById(R.id.twoFiguresAddition);
        final RadioGroup radioThreeGroup = (RadioGroup) findViewById(R.id.threeFiguresAddition);
        Button btnMathsDisplay = (Button) findViewById(R.id.btnMathsDisplay);

        btnMathsDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // initialise all the required variables

                // finalScore holds the final score
                // declaring Buttons

                //declaring radio buttons in Question One
                RadioButton answerOneThirty= (RadioButton) findViewById(R.id.maths_1_30);
                //declaring radio button
                RadioButton answerOneThirtyFour= (RadioButton) findViewById(R.id.maths_1_34);
                //declaring radio button
                RadioButton answerOneForty = (RadioButton) findViewById(R.id.maths_1_40);



                //declaring radio buttons in Question Three
                RadioButton answerThree600= (RadioButton) findViewById(R.id.three_600_radiobutton);
                //declaring radio button
                RadioButton answerThree563= (RadioButton) findViewById(R.id.three_563_radiobutton);
                //declaring radio button
                RadioButton answerThree700 = (RadioButton) findViewById(R.id.three_700_radiobutton);

                // questionMathsOneScore holds the question one score
                int questionMathsOneScore=0;
                // questionMathsTwoScore holds the question two score
                int questionMathsTwoScore=0;
                // questionMathsThreeScore holds the question two score
                int questionMathsThreeScore=0;
                // questionMathsFourScore holds the question two score
                int questionMathsFourScore=0;
                // questionFourComparisonScore holds the question four comparison double values
                double questionMathsFourComparisonScore=0;

                // check Question Two returns question two scores
                questionMathsTwoScore = checkMathsQuestionTwo();

                // get selected radio button from Question 1 radioGroup
                int selectedTwoId = radioTwoGroup.getCheckedRadioButtonId();

                if(selectedTwoId!=-1)
                {
                    // find the radiobutton by returned Question 1 id
                    RadioButton radioTwoButton = (RadioButton) findViewById(selectedTwoId);

                    if(selectedTwoId == answerOneForty.getId())
                    {
                        questionMathsOneScore = questionMathsOneScore + 1;
                    }
                    else
                    {
                        questionMathsOneScore = questionMathsOneScore + 0;
                    }


                }

                // get selected radio button from Question3 radioGroup
                int selectedThreeId = radioThreeGroup.getCheckedRadioButtonId();



                if(selectedThreeId!=-1)
                {
                    // find the radiobutton by returned Question 3 id
                    RadioButton radioThreeButton = (RadioButton) findViewById(selectedThreeId);
                    if(selectedThreeId == answerThree563.getId())
                    {
                        questionMathsThreeScore = questionMathsThreeScore + 1;

                    }
                    else
                    {
                        questionMathsThreeScore = questionMathsThreeScore + 0;
                    }
                }

                // check Question four comparison  scores percentage
                questionMathsFourComparisonScore = checkMathsQuestionFour();
                if (questionMathsFourComparisonScore > 0.8)
                {
                    questionMathsFourScore = questionMathsFourScore + 1;
                }
                else
                {
                    questionMathsFourScore = questionMathsFourScore + 0;

                }

                finalMathsScore = questionMathsOneScore + questionMathsTwoScore +  questionMathsThreeScore + questionMathsFourScore;
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                String MyEndScore = "Your Final Score is:" + finalMathsScore;
                Log.d("STATE",MyEndScore);
                Toast toast = Toast.makeText(context, MyEndScore, duration);
                toast.show();

                return;



            }


        });

    }
}

