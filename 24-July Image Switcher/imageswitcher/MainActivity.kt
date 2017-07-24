package com.bmpl.imageswitcher

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Downcasting
        val imageButton1 : Button = findViewById(R.id.imageOneButton) as Button
        val imageButton2 : Button = findViewById(R.id.imageTwoButton) as Button

        val imageView : ImageView = findViewById(R.id.imageView) as ImageView

        imageButton1.setOnClickListener {
            imageView.setImageResource(R.drawable.image1)
        }

        imageButton2.setOnClickListener {
            imageView.setImageResource(R.drawable.image2)
        }
    }
}