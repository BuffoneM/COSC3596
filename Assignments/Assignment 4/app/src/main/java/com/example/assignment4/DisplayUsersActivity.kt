package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class DisplayUsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val array = intent.getStringArrayExtra("empList")
        println("Within DisplayUsers, the array is: " + Arrays.toString(array))
        println("Now passing \"" + Arrays.toString(array) + "\" to the fragment...")

        val bundle = Bundle()
        bundle.putString("empArray", "testing string instead of array")
        val fragObj = EmployeeList()
        fragObj.arguments = bundle

        /*
        val bundle = Bundle()
        val myFragment = EmployeeList()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        bundle.putStringArray("empArray", array)
        myFragment.arguments = bundle
        fragmentTransaction.add(R.id.frameLayout, myFragment).commit()

         */
    }

}