package com.example.assignment4

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.TypedValue
import android.view.View
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

        // On show button press
        buttonHomeShowUser.setOnClickListener {
            val bundle = Bundle()
            val myFragment = EmployeeList()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Get all of the data from the database and put it in a String array
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

            bundle.putStringArrayList("EmployeeList", empList)
            myFragment.arguments = bundle
            fragmentTransaction.add(R.id.frameLayout, myFragment).commit()
        }

        // On add button press
        buttonHomeAddUser.setOnClickListener {
            btAddUserPress()
        }
    }

    private fun loadDatabase() {
        db = openOrCreateDatabase("employeeNames", MODE_PRIVATE, null)

        // Create the employee table
        db.execSQL("DROP TABLE IF EXISTS employees")
        db.execSQL("CREATE TABLE employees (name VARCHAR(32))")

        // Insert names
        db.execSQL("INSERT INTO employees VALUES('Red')")
        db.execSQL("INSERT INTO employees VALUES('Chuck')")
        db.execSQL("INSERT INTO employees VALUES('Matilda')")


    }

    fun btShowAllPress() {
        val intent = Intent(this, DisplayUsersActivity::class.java)
        startActivity(intent)
    }

    fun btAddUserPress() {
        val context = this
        val builder = MaterialAlertDialogBuilder(context)

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


        }

        // Display the dialog
        val dialog = builder.create()
        dialog.show()
    }

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