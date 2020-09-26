package com.example.assignment2p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btOrderClick(View view) {


        int selectedId = ((RadioGroup)findViewById(R.id.rgPizzaSizes)).getCheckedRadioButtonId();
        System.out.println(selectedId);
        String pizza = "You ordered a " + ((RadioButton)findViewById(selectedId)).getText();

        if(((CheckBox)findViewById(R.id.cbCheese)).isChecked()) pizza += " Cheese";
        if(((CheckBox)findViewById(R.id.cbPepperoni)).isChecked()) pizza += " Pepperoni";

        pizza += " Pizza";

        (((TextView)findViewById(R.id.finalOrder))).setText(pizza);
    }
}