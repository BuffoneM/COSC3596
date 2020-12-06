package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class DisplayUsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val empIntent = Intent(this, EmployeeList::class.java)
        val array = intent.getStringArrayExtra("empList")

        println("Within DisplayUsers, the array is: " + Arrays.toString(array))
        empIntent.putExtra("empArray", array)

    }

}