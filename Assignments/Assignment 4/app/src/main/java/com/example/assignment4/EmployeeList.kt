package com.example.assignment4

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.ListFragment

class EmployeeList : ListFragment() {
    private val myArray = arrayOf("Red", "Chuck", "Matilda")

    override fun onActivityCreated(savedState: Bundle?) {

        super.onActivityCreated(savedState)
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