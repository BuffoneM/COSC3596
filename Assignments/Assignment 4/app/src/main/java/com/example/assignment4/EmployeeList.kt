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
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class EmployeeList : ListFragment() {

    private var db: SQLiteDatabase = (activity as HomeActivity).loadDatabase()
    private val myArray = arrayOf("Red", "Chuck", "Matilda")

    override fun onActivityCreated(savedState: Bundle?) {
        super.onActivityCreated(savedState)

        // Get the ArrayList of employees
        /*
        val empList = ArrayList<String>()
        val query = "SELECT * FROM employees"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                for (i in 0 until cursor.columnCount) {
                    empList.add(cursor.getString(i))
                }
            } while (cursor.moveToNext())
        }
*/
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