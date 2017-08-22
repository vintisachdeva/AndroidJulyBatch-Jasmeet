package com.bmpl.calc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // global declaration
    //var textView : TextView? = null
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.userInputTextView) as TextView
    }
        fun buttonClicked(view: View){
            //var i = view.id
            var button = findViewById(view.id) as Button

            if(!userInputTextView.text.isEmpty())
                userInputTextView.text = userInputTextView.text.toString().plus(button.text)
            else
                userInputTextView.text = button.text
        }
}
