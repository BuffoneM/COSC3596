package com.example.programmingtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int number;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Generate random number
        generateRandomNumber();
    }

    protected void generateRandomNumber() {
        number = 0 + (int)(Math.random() * (101));
        (((TextView)findViewById(R.id.txtNumber))).setText("Is " + number + " even or odd?");
    }

    protected void correctToast() {
        Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
        toast.show();
    }

    protected void wrongToast() {
        Toast toast = Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void btEvenClick(View view) {
        if((number % 2) == 0) {
            (((TextView)findViewById(R.id.txtScore))).setText("" + (++score));
            correctToast();
            generateRandomNumber();
        }
        else {
            (((TextView)findViewById(R.id.txtScore))).setText("" + (--score));
            wrongToast();
            generateRandomNumber();
        }
    }

    public void btOddClick(View view) {
        if((number % 2) != 0) {
            (((TextView)findViewById(R.id.txtScore))).setText("" + (++score));
            correctToast();
            generateRandomNumber();
        }
        else {
            (((TextView)findViewById(R.id.txtScore))).setText("" + (--score));
            wrongToast();
            generateRandomNumber();
        }
    }

}