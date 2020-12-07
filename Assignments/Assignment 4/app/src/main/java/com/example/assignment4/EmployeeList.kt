package com.example.assignment4

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.ListFragment
import android.content.Intent
import android.content.Intent.getIntent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class EmployeeList : ListFragment() {

    private val myArray = arrayOf("Red", "Chuck", "Matilda")

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle) {
        val array = this.arguments!!.getStringArray("empArray")
        println("Within EmployeeList, the array is: " + Arrays.toString(array))
    }


    override fun onActivityCreated(savedState: Bundle?) {
        super.onActivityCreated(savedState)

        val bundle = arguments
        val array = bundle!!.getStringArray("empArray")

        println("Within EmployeeList, the array is: " + Arrays.toString(array))

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