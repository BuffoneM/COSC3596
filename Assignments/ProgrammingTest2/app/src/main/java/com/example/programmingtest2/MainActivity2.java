package com.example.programmingtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Double value = getIntent().getDoubleExtra("key0", 0);
        String currency = getIntent().getExtras().getString("key1");

        TextView textDisplay = new TextView(this);
        textDisplay.setTextSize(30);
        if(currency.equals("usd")) {
            textDisplay.setText("$CAD " + value + " is $USD " + value * 0.8);
        }
        else if(currency.equals("euro")) {
            textDisplay.setText("$CAD " + value + " is Euro " + value * 0.64);
        }
        else {
            textDisplay.setText("Error with conversion...");
        }

        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        myLayout.setOrientation(LinearLayout.HORIZONTAL);

        myLayout.setGravity(Gravity.CENTER);
        myLayout.addView(textDisplay);
        setContentView(myLayout);

    }
}