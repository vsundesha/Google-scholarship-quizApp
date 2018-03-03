package com.example.android.quiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quiz.R.string.toast;


public class MainActivity extends AppCompatActivity {

    static int totalPoints;
    RadioButton q1a1c;
    RadioButton q2a1c;
    CheckBox q3a1c;
    CheckBox q3a2c;
    EditText q4a1c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1a1c = (RadioButton) findViewById(R.id.q1a1c);
        q2a1c = (RadioButton) findViewById(R.id.q2a1c);
        q3a1c = (CheckBox) findViewById(R.id.q3a1c);
        q3a2c = (CheckBox) findViewById(R.id.q3a2c);
        q4a1c = (EditText) findViewById(R.id.q4a1c);



    }

    /*
        On submit counts the points
     */
    public void submit(View v) {
        totalPoints=0;

        System.out.println(q4a1c.getText().toString());
        if(q1a1c.isChecked()) {
            totalPoints ++;
        }
        if(q2a1c.isChecked()) {
            totalPoints ++;
        }
        if (q3a2c.isChecked() && q3a1c.isChecked()) {
            totalPoints ++;
        }
        if (q4a1c.getText().toString().toLowerCase().equals("oreo")){
            totalPoints ++;
        }

        System.out.println(totalPoints);
        this.score(totalPoints);

    }
    /*
        Sets the score
        @param totalpoints
     */
    public void score(int totalPoints){
        Context context = getApplicationContext();
        String mess;
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;

        if (totalPoints == 4){
            mess = getResources().getString(R.string.toast2);
            text = String.format(mess, totalPoints);
            Toast.makeText(context,text,duration).show();
        } else {
            mess = getResources().getString(R.string.toast);
            text = String.format(mess, totalPoints);
            Toast.makeText(context, text, duration).show();
        }
    }
    /*
        reset the app and clear all answers
     */
    public void resetAnswers(View v) {
        totalPoints = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
