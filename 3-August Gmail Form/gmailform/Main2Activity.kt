package com.bmpl.gmailform

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var textView : TextView = findViewById(R.id.textView) as TextView

        var intent  = intent

        var first = intent.getStringExtra("first")
        var last = intent.getStringExtra("last")
        var password = intent.getStringExtra("password")
        var email = intent.getStringExtra("email")

        var month = intent.getStringExtra("month")
        var year = intent.getStringExtra("year")
        var day = intent.getStringExtra("day")

        textView.text = "Welcome " + first + "\n" +
                                    last + "\n" +
                                    password + "\n" +
                                    email + "\n" +
                                    month + "\n" +
                                    year + "\n" +
                                    day
    }
}
