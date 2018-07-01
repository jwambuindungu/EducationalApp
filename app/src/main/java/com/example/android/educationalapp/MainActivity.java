package com.example.android.educationalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mathsCat=(Button) findViewById(R.id.maths_cat);
        Button geographyCat=(Button) findViewById(R.id.geography_cat);
        Button othersCat=(Button) findViewById(R.id.others_cat);


        geographyCat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent GeographyIntent = new Intent(MainActivity.this, Geography.class);
                // calling an activity using <intent-filter> action name
                //  Intent intent = new Intent("  com.example.android.miwok.number");
                startActivity(GeographyIntent);

            }
        });


        mathsCat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent MathsIntent = new Intent(MainActivity.this, Maths.class);
                startActivity(MathsIntent);

            }
        });

        othersCat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent MathsIntent = new Intent(MainActivity.this, OthersActivity.class);
                startActivity(MathsIntent);

            }
        });

    }
}
