package com.bmpl.internalstorage_jasmeet

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()

            var outputStream = OutputStreamWriter(openFileOutput("userData", Context.MODE_APPEND))

            var bufferedWriter = BufferedWriter(outputStream)

            bufferedWriter.write(name)
            bufferedWriter.appendln(email)
            //bufferedWriter.write(email.plus("\n"))
            Toast.makeText(this, "Data written", Toast.LENGTH_LONG).show()
            bufferedWriter.close()

//            val sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE).edit()
//            sharedPreferences.putString("name", name)
//            sharedPreferences.putString("email", email)
//            sharedPreferences.commit()
        }

        loadButton.setOnClickListener {

            val inputStream = InputStreamReader(openFileInput("userData"))
            val bufferedReader = BufferedReader(inputStream)

            while(bufferedReader.readLine()!=null){
                textView.text = textView.text.toString().plus(bufferedReader.readLine())
            }
            bufferedReader.close()
//            val sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE)
//            textView.text = sharedPreferences.getString("name", "no data found")
//                    .plus( "\n" + sharedPreferences.getString("email", "no data found"))

        }
    }
}
