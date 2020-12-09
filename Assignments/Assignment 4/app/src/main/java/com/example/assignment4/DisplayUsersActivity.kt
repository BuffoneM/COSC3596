package com.example.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.*

class DisplayUsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val array = intent.getStringArrayExtra("empList")
        println("Within DisplayUsers, the array is: " + Arrays.toString(array))
        println("Now passing \"" + Arrays.toString(array) + "\" to the fragment...")

        val bundle = Bundle()
        bundle.putStringArray("empArray", array)
        EmployeeListFragment.arguments = bundle

    }

}