package com.example.assignment4

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.ListFragment
import android.content.Intent
import android.content.Intent.getIntent
import kotlinx.android.synthetic.main.activity_main2.*

class EmployeeList : ListFragment() {
    private val myArray = arrayOf("Red", "Chuck", "Matilda")
    //private val myArray = null

    override fun onActivityCreated(savedState: Bundle?) {
        super.onActivityCreated(savedState)

        // Get the ArrayList of employees
        val bundle = arguments
        val array = bundle!!.getStringArrayList("EmployeeList")
        println("The fragment array of employees is: " + array.toString())

        val myAdapter = ArrayAdapter(
                activity!!,
                android.R.layout.simple_list_item_1,
                myArray
        )
        listAdapter = myAdapter

    }

    override fun onListItemClick(l: ListView, v: View, pos: Int, id: Long) {
        Toast.makeText(activity, "You clicked " + myArray[pos], Toast.LENGTH_LONG).show()
    }
}