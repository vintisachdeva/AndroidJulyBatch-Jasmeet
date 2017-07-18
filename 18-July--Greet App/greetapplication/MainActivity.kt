package com.bmpl.greetapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // var keyword
    // val keyword

    //val variable_name : Type = initialization
    val value : String = "hello"
    val value2 : Int = 10//final variable constant

    val value1 = 10//normal variable



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //kotlin file binding with layout file
        setContentView(R.layout.activity_main)
        // R -- > R.java--> java file Predefined id(int) in R file

        //value = value + 10

        //value1 = value + 10

       //var variable_name

        var resultTextView : TextView = findViewById(R.id.resultTextView) as TextView

        var nameEditText : EditText = findViewById(R.id.nameEditText) as EditText

        var submit: Button = findViewById(R.id.submitButton) as Button

    }
}






