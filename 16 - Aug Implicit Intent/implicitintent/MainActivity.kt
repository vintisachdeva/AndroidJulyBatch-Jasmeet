package com.bmpl.implicitintent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Implicit intent--> communication outside application

        var send : Button  = findViewById(R.id.sendButton) as Button

        //var intent1 : Intent()
        //Implicit Intent--> transfer data from one app to another app

        send.setOnClickListener {

/*              val intent = Intent()//fix or final
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "This is my data")
                startActivity(Intent.createChooser(intent, "Select Anyone"))*/

            //compose: To: / subject / body

            val intent = Intent()//fix or final
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            //intent.`package` = "com.whatsapp"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("abc@gmail.com") )
            intent.putExtra(Intent.EXTRA_SUBJECT, "this is my subject")
            intent.putExtra(Intent.EXTRA_TEXT, "This is my mail body")//body
            //startActivity(intent)
            startActivity(Intent.createChooser(intent, "Select Anyone"))

        }
    }
}