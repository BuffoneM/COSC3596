package com.example.assignment4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class EmployeeListFragment : Fragment() {
    private val myArray = arrayOf("Red", "Chuck", "Matilda")

    override fun onActivityCreated(savedState: Bundle?) {
        super.onActivityCreated(savedState)
        val myAdapter = ArrayAdapter(
            activity!!,
            R.layout.simple_list_item_1,
            myArray
        )
        listAdapter = myAdapter
    }

    fun onListItemClick(l: ListView, v: View, pos: Int, id: Long) {
        Toast.makeText(activity, "You clicked " + myArray[pos], Toast.LENGTH_LONG).show()
    }
}