package com.example.assignment4

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.ListFragment

class EmployeeList : ListFragment() {

    private lateinit var myArray : Array<String>

    override fun onActivityCreated(savedState: Bundle?) {
        super.onActivityCreated(savedState)

        myArray = arguments?.getStringArray("empArray") as Array<String>
        val myAdapter = ArrayAdapter(
                activity!!,
                android.R.layout.simple_list_item_1,
                myArray
        )
        listAdapter = myAdapter

    }
}