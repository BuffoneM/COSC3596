package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textViewHomeName.setText("Hello " + intent.getStringExtra("Username"))

        buttonHomeAddUser.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            //set title for alert dialog
            //builder.setTitle(R.string.dialogTitle)
            //set message for alert dialog
            //builder.setMessage(R.string.dialogMessage)
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("Add"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Clicked Add",Toast.LENGTH_SHORT).show()
            }
            //performing cancel action
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,"Clicked Cancel",Toast.LENGTH_SHORT).show()
            }

            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }

    fun btShowAllPress(view: View) {
        val intent = Intent(this, DisplayUsersActivity::class.java)
        startActivity(intent)
    }

    fun openDialog() {

    }

}