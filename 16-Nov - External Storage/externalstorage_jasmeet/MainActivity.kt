package com.bmpl.externalstorage_jasmeet

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR

        //Environment.getExternalStorageDirectory()//path of sd card
        var pathOfStorage : File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)//path of internal storage

        var file = File(pathOfStorage, "mydata.txt")

        saveButton.setOnClickListener{
            var name = nameEditText.text.toString()
            var password = passwordEditText.text.toString()

            var fileWriter = FileWriter(file, true)

            fileWriter.write(name)
            fileWriter.write(password)

            Toast.makeText(this, "Data written", Toast.LENGTH_LONG).show()
            fileWriter.close()
        }

        loadButton.setOnClickListener{

            val fileReader : FileReader = FileReader(file)
            val bufferedReader : BufferedReader = BufferedReader(fileReader)

            val data = bufferedReader.use { it.readText() }
            Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        }
    }
}