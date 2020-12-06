package com.example.assignment4

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*;

class LoginActivity : AppCompatActivity() {

    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadDatabase();
    }

    private fun loadDatabase() {
        db = openOrCreateDatabase("loginInformation", MODE_PRIVATE, null)

        // Create the user table
        db.execSQL("DROP TABLE IF EXISTS users")
        db.execSQL("CREATE TABLE users (" +
                "username VARCHAR(32) PRIMARY KEY, " +
                "password VARCHAR(32))")

        // Insert valid login credentials
        db.execSQL("INSERT INTO users VALUES('admin', '1234')")

    }

    fun btLoginClick(view: View) {
        var username = editTextUsername.text.toString()
        var password = editTextTextPassword.text.toString()

        println(username + " " + password)

        val query = "SELECT * FROM users WHERE username = '$username' AND password = '$password'"
        val cursor = db.rawQuery(query, null)

        if(cursor.moveToFirst()) {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("Username", username)
            Toast.makeText(this, "Successful Login!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Incorrect Credentials!", Toast.LENGTH_SHORT).show()
        }
    }


}