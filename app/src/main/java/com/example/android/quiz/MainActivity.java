package com.example.android.quiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quiz.R.string.toast;


public class MainActivity extends AppCompatActivity {

    static int totalPoints;
    RadioButton q1a1c;
    RadioButton q2a1c;
    RadioButton q3a2c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1a1c = (RadioButton) findViewById(R.id.q1a1c);
        q2a1c = (RadioButton) findViewById(R.id.q2a1c);
        q3a2c = (RadioButton) findViewById(R.id.q3a2c);

    }

    public void submit(View v) {
        totalPoints=0;
        if(q1a1c.isChecked()) {
            totalPoints ++;
        }
        if(q2a1c.isChecked()) {
            totalPoints ++;
        }
        if (q3a2c.isChecked()) {
            totalPoints ++;
        }

        System.out.println(totalPoints);
        this.score(totalPoints);

    }

    public void score(int totalPoints){
        Context context = getApplicationContext();
        String mess = getResources().getString(R.string.toast);
        CharSequence text = String.format(mess, totalPoints);;
        int duration = Toast.LENGTH_SHORT;


        if(MainActivity.totalPoints > 0 || MainActivity.totalPoints < 3) {
            Toast.makeText(context, text, duration).show();


        } else if (MainActivity.totalPoints == 0) {
            Toast.makeText(context, text, duration).show();


        } else if (MainActivity.totalPoints ==  3){
            Toast.makeText(context, text, duration).show();


        }
    }

    public void resetAnswers(View v) {
        totalPoints = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
