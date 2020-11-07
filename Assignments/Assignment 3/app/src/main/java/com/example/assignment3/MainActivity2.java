package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ((TextView)findViewById(R.id.textDisplay1)).setText("Hello " + getIntent().getExtras().getString("key1") + ",");
        ((TextView)findViewById(R.id.textDisplay2)).setText("Your midterm exam mark is " + getIntent().getExtras().getString("key2") + ".");

    }
}