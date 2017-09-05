package com.bmpl.calc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // global declaration
    //var textView : TextView? = null
    lateinit var textView: TextView
    var value1 = 0
    var value2 = 0
    lateinit var operation : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.userInputTextView) as TextView
    }
        fun buttonClicked(view: View){
            //var i = view.id
            Log.d("buttonClicked ", "id "+ view.id);

            var button = findViewById(view.id) as Button

            if(!userInputTextView.text.isEmpty())
                                            //85
                userInputTextView.text = userInputTextView.text.toString().plus(button.text)
            else
              userInputTextView.text = button.text
        }

        fun operationRequest(view: View) {

            var button = findViewById(view.id) as Button

            if(userInputTextView.text.isEmpty() && resultTextView.text.isEmpty()){
               Toast.makeText(this, "Cannot add empty fields", Toast.LENGTH_LONG).show()
            } else if(!resultTextView.text.isEmpty()){
                value1  = resultTextView.text.toString().toInt()
                operation = button.text.toString()
                userInputTextView.text = resultTextView.text.toString().plus(operation)
                //operation = button.text.toString()
            }
            else {
               value1 = userInputTextView.text.toString().toInt()
                operation = button.text.toString()
                userInputTextView.text = userInputTextView.text.toString().plus(operation)
                //userInputTextView.text = ""

            }
        }

    fun result(view: View){
        if(userInputTextView.text.isEmpty()){
            Toast.makeText(this, "Enter digit first", Toast.LENGTH_LONG).show()
        } else{
            value2 = userInputTextView.text.toString().substringAfter(operation).toInt()
            //value2 = userInputTextView.text.toString().toInt()
            userInputTextView.text = ""
            calculateResult(operation)
        }
    }

    fun calculateResult(operation : String){
        var total = 0

        if(operation.equals("+"))
            total = value1 + value2

        else if(operation.equals("-"))
            total = value1 - value2

        else if(operation.equals("x"))
            total = value1 * value2

        else if(operation.equals("/"))
            total = value1 / value2

        resultTextView.text = total.toString()
    }

    fun clear(view: View){
        userInputTextView.text = ""
        resultTextView.text = ""
        value1 = 0
        value2 = 0
    }

    fun singleClear(view: View){
        //dropLast(1)--> 1 represent the no. of digits should be removed from last
        userInputTextView.text = userInputTextView.text.dropLast(1)
    }
}