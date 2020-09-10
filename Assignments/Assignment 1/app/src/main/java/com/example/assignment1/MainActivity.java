package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Button btn = (Button)findViewById(R.id.michaelButton);
        if(btn.getText() == "Hello Michael!")
            btn.setText("Goodbye Michael!");
        else
            btn.setText("Hello Michael!");
    }
}