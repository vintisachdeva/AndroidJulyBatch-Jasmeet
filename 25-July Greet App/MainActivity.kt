package com.bmpl.greetapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // var keyword--> normal variable
    // val keyword--> final variable/constant

    //val variable_name : Type = initialization
    //int num = 10; java
    //var--> normal variable

    var num : Int = 10
    val num1 : Int = 20

    var value : String = "hello"
    val value2 : Int = 10//final variable constant

    val value1 = 10//normal variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //kotlin file binding with layout file
        setContentView(R.layout.activity_main)
        // R -- > R.java--> java file Predefined id(int) in R file

        //int value = 10;
        //Step:1 Downcast

        var resultTextView : TextView = findViewById(R.id.resultTextView) as TextView

        var nameEditText : EditText = findViewById(R.id.nameEditText) as EditText

        var  passwordEditText : EditText = findViewById(R.id.passwordEditText) as EditText

        var submit: Button = findViewById(R.id.submitButton) as Button

        var cancel : Button = findViewById(R.id.cancelButton) as Button

        //Step:2 Attach Listener

        submit.setOnClickListener {
            //Step: 3 Handler

            var name : String = nameEditText.text.toString()
            var password: String = passwordEditText.text.toString()

            //isBlank() --> check the length of string and whitespace also
            if(name.isBlank() || password.isBlank())
                Toast.makeText(this, "Enter your details first", Toast.LENGTH_LONG).show()
                //resultTextView.text = "Enter your details first"
            else
                resultTextView.text = "Welcome " + name + "\n" + password
        }

        cancel.setOnClickListener {

            nameEditText.text = null
            passwordEditText.text = null

            resultTextView.text = " "
        }
    }

}