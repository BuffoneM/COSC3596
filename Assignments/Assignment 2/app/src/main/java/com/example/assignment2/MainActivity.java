package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btClearClick(View view) {
        ((EditText)findViewById(R.id.assignmentInput)).setText("");
        ((EditText)findViewById(R.id.examInput)).setText("");
        ((TextView)findViewById(R.id.output)).setText("Final Grade");
    }

    public void btCalculateClick(View view) {
        String assignInput = ((EditText)findViewById(R.id.assignmentInput)).getText().toString();
        String examInput = ((EditText)findViewById(R.id.examInput)).getText().toString();
        int finalGrade = (Integer.parseInt(assignInput) + Integer.parseInt(examInput)) / 2;
        ((TextView)findViewById(R.id.output)).setText("Your final grade is " + finalGrade);
    }
}