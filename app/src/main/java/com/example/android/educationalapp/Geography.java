package com.example.android.educationalapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Geography extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geography);
        addListenerOnButton();


    }
    int totalScore=0;
    int finalScore=0;

    // Get the checked checkBoxes in Question 2
    private int checkQuestionTwo()
    {
        CheckBox Brazil = (CheckBox) findViewById(R.id.brazil_checkbox);
        Boolean brazilState=Brazil.isChecked();

        CheckBox Kenya = (CheckBox) findViewById(R.id.kenya_checkbox);
        Boolean KenyaState=Kenya.isChecked();

        CheckBox Russia = (CheckBox) findViewById(R.id.russia_checkbox);
        Boolean RussiaState=Russia.isChecked();

        if (brazilState)
        {
            // add a mark is Brazil is selected
            totalScore=totalScore + 1;
        }

        if (KenyaState)
        {
            Context context = getApplicationContext();
            CharSequence text = "Kenya has never hosted World Cup";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        if (RussiaState)
        {
            // add a mark is Russia is selected
            totalScore=totalScore + 1;
        }
        return totalScore;
    }



    public double  checkQuestionFour()
    {
        EditText Question4Answer = (EditText)findViewById(R.id.fourth_question);
        String correctAnswer = "UNITED STATES OF AMERICA";
        String resultName = Question4Answer.getText().toString();
        double Comparison = similarity(resultName, correctAnswer);

        return Comparison;
    }

    /**
     * Calculates the similarity (a number within 0 and 1) between two strings.
     */
    public static double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
        /* // If you have StringUtils, you can use it to calculate the edit distance:
        return (longerLength - StringUtils.getLevenshteinDistance(longer, shorter)) /
                                                             (double) longerLength; */
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;

    }

    // Example implementation of the Levenshtein Edit Distance
    // See http://r...content-available-to-author-only...e.org/wiki/Levenshtein_distance#Java
    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }



    public void addListenerOnButton() {

        final RadioGroup radioContinentGroup = (RadioGroup) findViewById(R.id.radioContinent);
        final RadioGroup radioUniverseGroup = (RadioGroup) findViewById(R.id.radioPlanets);
        Button btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // initialise all the required variables

                // finalScore holds the final score
                // declaring Buttons

                //declaring radio buttons in Question One
                RadioButton answerOneten= (RadioButton) findViewById(R.id.ten_radiobutton);
                //declaring radio button
                RadioButton answerOneEight = (RadioButton) findViewById(R.id.eight_radiobutton);
                //declaring radio button
                RadioButton answerOneThree = (RadioButton) findViewById(R.id.three_radiobutton);



                //declaring radio buttons in Question Three
                RadioButton answerThreeEurope= (RadioButton) findViewById(R.id.europe_radiobutton);
                //declaring radio button
                RadioButton answerThreeAfrica = (RadioButton) findViewById(R.id.africa_radiobutton);
                //declaring radio button
                RadioButton answerThreeAsia = (RadioButton) findViewById(R.id.asia_radiobutton);



                // questionOneScore holds the question one score
                int questionOneScore=0;
                // questionTwoScore holds the question two score
                int questionTwoScore=0;
                // questionThreeScore holds the question two score
                int questionThreeScore=0;
                // questionFourScore holds the question two score
                int questionFourScore=0;
                // questionFourComparisonScore holds the question four comparison double values
                double questionFourComparisonScore=0;

                // checkQuestionTwo returns question two scores
                 questionTwoScore = checkQuestionTwo();

                // get selected radio button from Question 1 radioGroup
                int selectedUniverseId = radioUniverseGroup.getCheckedRadioButtonId();

                if(selectedUniverseId!=-1)
                {
                    // find the radiobutton by returned Question 1 id
                    RadioButton radioUniverseButton = (RadioButton) findViewById(selectedUniverseId);

                    if(selectedUniverseId == answerOneEight.getId())
                    {
                        questionOneScore = questionOneScore + 1;
                    }
                    else
                    {
                        questionOneScore = questionOneScore + 0;
                    }


                }


                // get selected radio button from Question3 radioGroup
                int selectedContinentId = radioContinentGroup.getCheckedRadioButtonId();



                if(selectedUniverseId!=-1)
                {
                    // find the radiobutton by returned Question 3 id
                    RadioButton radioContinentButton = (RadioButton) findViewById(selectedContinentId);
                    if(selectedContinentId == answerThreeAsia.getId())
                    {
                        questionThreeScore = questionThreeScore + 1;

                    }
                    else
                    {
                        questionThreeScore = questionThreeScore + 0;
                    }
                }


                // check Question four comparison  scores percentage
                questionFourComparisonScore = checkQuestionFour();
                if (questionFourComparisonScore > 0.5)
                {
                    questionFourScore = questionFourScore + 1;
                }
                else
                {
                    questionFourScore = questionFourScore + 0;

                }




                finalScore = questionOneScore + questionTwoScore +  questionThreeScore + questionFourScore;
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                String MyEndScore = "Your Final Score is:" + finalScore;
                Log.d("STATE",MyEndScore);
                Toast toast = Toast.makeText(context, MyEndScore, duration);
                toast.show();

                return;
            }

        });

    }

}
