package com.example.programmingtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnUSPress(View view) {
        Double oldNum = Double.parseDouble(((EditText)findViewById(R.id.edittextInput)).getText().toString());
        String currency = "usd";

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("key0", oldNum);
        intent.putExtra("key1", currency);
        startActivity(intent);

    }

    public void btnEuroPress(View view) {
        Double oldNum = Double.parseDouble(((EditText)findViewById(R.id.edittextInput)).getText().toString());
        String currency = "euro";

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("key0", oldNum);
        intent.putExtra("key1", currency);
        startActivity(intent);
    }
}