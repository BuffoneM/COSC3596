package com.example.assignment4

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main2.*


class HomeActivity : AppCompatActivity() {
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        loadDatabase()

        // Welcoming message
        textViewHomeName.setText("Hello " + intent.getStringExtra("Username"))

        // On add button press
        buttonHomeAddUser.setOnClickListener {
            btAddUserPress()
        }

        // On delete button press
        buttonHomeDeleteUser.setOnClickListener {
            btDeleteUserPress()
        }
    }

    fun loadDatabase() {
        db = openOrCreateDatabase("employeeNames", MODE_PRIVATE, null)

        // Create the employee table
        db.execSQL("DROP TABLE IF EXISTS employees")
        db.execSQL("CREATE TABLE employees (name VARCHAR(32))")

        // Insert names
        db.execSQL("INSERT INTO employees VALUES('UserA')")
        db.execSQL("INSERT INTO employees VALUES('UserB')")
        db.execSQL("INSERT INTO employees VALUES('UserC')")

    }

    fun printDatabase() {
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

        println("The database is: " + empList)
    }

    fun btShowAllPress(view: View) {
        val intent = Intent(this, DisplayUsersActivity::class.java)

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

        var tempArray = arrayOfNulls<String>(empList.size)
        intent.putExtra("empList", empList.toArray(tempArray))

        startActivity(intent)
    }

    fun btAddUserPress() {
        val context = this
        val builder = MaterialAlertDialogBuilder(context, R.style.ThemeOverlay_MaterialComponents_Light)

        println("Add button pressed...")

        // dialog title
        builder.setTitle("Enter the employee's name:")
        builder.setNeutralButton("Cancel", null)
        builder.setCancelable(false)

        // dialog message view
        val constraintLayout = getEditTextLayout(context)
        builder.setView(constraintLayout)

        val textInputEditText = constraintLayout.findViewWithTag<TextInputEditText>("textInputEditTextTag")

        builder.setPositiveButton("Add") { dialog, which ->
            val name = textInputEditText.text
            db.execSQL("INSERT INTO employees VALUES('$name')")
            Toast.makeText(this, "Added the user: " + name, Toast.LENGTH_SHORT).show()

        }

        printDatabase()

        // Display the dialog
        val dialog = builder.create()
        dialog.show()
    }

    fun btDeleteUserPress() {
        val context = this
        val builder = MaterialAlertDialogBuilder(context)

        println("Delete button pressed...")

        // dialog title
        builder.setTitle("Enter the employee's name:")
        builder.setNeutralButton("Cancel", null)
        builder.setCancelable(false)

        // dialog message view
        val constraintLayout = getEditTextLayout(context)
        builder.setView(constraintLayout)

        val textInputEditText = constraintLayout.findViewWithTag<TextInputEditText>("textInputEditTextTag")

        builder.setPositiveButton("Delete") { dialog, which ->
            val inputName = textInputEditText.text

            val query = "SELECT * FROM employees WHERE name = '$inputName'"
            val cursor = db.rawQuery(query, null)

            if(cursor.moveToFirst()) {
                db.execSQL("DELETE FROM employees WHERE name = '$inputName'")
                Toast.makeText(this, "Successfully deleted: " + inputName, Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "" + inputName + " is not found!", Toast.LENGTH_SHORT).show()
            }
        }

        printDatabase()

        val dialog = builder.create()
        dialog.show()
    }

    // I referenced this tutorial on how to create the AlertDialog with editText
    // https://code-android-example.blogspot.com/2020/03/alertdialog-edittext-android-kotlin.html
    private fun getEditTextLayout(context: Context): ConstraintLayout {
        val constraintLayout = ConstraintLayout(context)
        val layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        constraintLayout.layoutParams = layoutParams
        constraintLayout.id = View.generateViewId()

        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)

        // Edit text portion of dialog
        val textInputLayout = TextInputLayout(context)
        textInputLayout.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
        layoutParams.setMargins(
                32.toDp(context),
                8.toDp(context),
                32.toDp(context),
                8.toDp(context)
        )
        textInputLayout.layoutParams = layoutParams
        textInputLayout.hint = "Name"
        textInputLayout.id = View.generateViewId()
        textInputLayout.tag = "textInputLayoutTag"

        val textInputEditText = TextInputEditText(context)
        textInputEditText.id = View.generateViewId()
        textInputEditText.tag = "textInputEditTextTag"

        textInputLayout.addView(textInputEditText)
        constraintLayout.addView(textInputLayout)

        return constraintLayout
    }

    private fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
    ).toInt()

}