package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private class Student {
        String name;
        String id;
        String grade;
        Student(String name, String id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnSubmitPress(View view) {
        String userName = ((EditText)findViewById(R.id.inputName)).getText().toString();
        String userId = ((EditText)findViewById(R.id.inputID)).getText().toString();

        // No name or ID entered
        if(userName.equals("") || userId.equals("")) {
            Toast.makeText(getApplicationContext(), "Missing Name / ID", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create scanner to file, and put all of the students in the linked list
        Scanner input = new Scanner(getResources().openRawResource(R.raw.exammarks));
        LinkedList<Student> students = new LinkedList<Student>();
        while(input.hasNextLine()) {
            students.add(new Student(input.next(), input.next(), input.next()));
        }

        // If student name is found and id correct
        for(Student i : students) {
            if(userName.equals(i.name)) {
                if(userId.equals(i.id)) {

                    // Found the correct name and id
                    Intent intent = new Intent(this, MainActivity2.class);
                    intent.putExtra("key1", userName);
                    intent.putExtra("key2", i.grade);
                    startActivity(intent);
                    return;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong student ID", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
        // If student name cannot be found
        Toast.makeText(getApplicationContext(), "Student name does not exist", Toast.LENGTH_SHORT).show();
    }
}