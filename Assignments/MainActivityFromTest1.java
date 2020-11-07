package com.example.question1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btClick(View view) {
        String userNum = ((EditText)findViewById(R.id.userNum)).getText().toString();
        sum += (Integer.parseInt(userNum));
        Toast.makeText(this, "" + sum, Toast.LENGTH_SHORT).show();
        ((EditText)findViewById(R.id.userNum)).setText("");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("savedUserSum", sum);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sum = savedInstanceState.getInt("savedUserSum");
    }

}