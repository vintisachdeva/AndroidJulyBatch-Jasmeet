package com.bmpl.gmailform

import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstName : EditText = findViewById(R.id.firstEditText) as EditText
        var lastName : EditText = findViewById(R.id.lastEditText) as EditText

        var password : EditText = findViewById(R.id.passwordEditText) as EditText
        var email : EditText = findViewById(R.id.gmailEditText) as EditText

        var monthSpinner : Spinner = findViewById(R.id.spinnerMonth) as Spinner
        var year : EditText = findViewById(R.id.yearEditText) as EditText
        var day : EditText = findViewById(R.id.dayEditText) as EditText

        var loginButton : Button = findViewById(R.id.loginButton) as Button

        if(firstName.isSelected)
            firstName.background = R.drawable.selected_edittext as Drawable

        loginButton.setOnClickListener{

            /*var fName = firstName.text.toString()
            var lName = lastName.text.toString()
            */
            var intent = Intent(this,Main2Activity::class.java)

            intent.putExtra("first", firstName.text.toString())
            intent.putExtra("last", lastName.text.toString())
            intent.putExtra("password", password.text.toString())
            intent.putExtra("email", email.text.toString())

            //spinner
            intent.putExtra("month", monthSpinner.selectedItem.toString())
            intent.putExtra("year",year.text.toString())
            intent.putExtra("day", day.text.toString())

/*            intent.putExtra("first", fName)
            intent.putExtra("last", lName)*/
            startActivity(intent)
            //Intent intent = new Intent();
        }
    }
}