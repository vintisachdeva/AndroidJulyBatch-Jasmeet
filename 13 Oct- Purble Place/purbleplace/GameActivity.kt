package com.bmpl.purbleplace

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import java.util.*

class GameActivity : AppCompatActivity() {

    lateinit var image1 : ImageView
    lateinit var image2 : ImageView
    lateinit var image3 : ImageView
    lateinit var image4 : ImageView
    lateinit var image5 : ImageView
    lateinit var image6 : ImageView
    lateinit var image7 : ImageView
    lateinit var image8 : ImageView
    lateinit var image9 : ImageView
    lateinit var image10 : ImageView
    lateinit var image11 : ImageView
    lateinit var image12 : ImageView
    lateinit var image13 : ImageView
    lateinit var image14 : ImageView
    lateinit var image15 : ImageView
    lateinit var image16 : ImageView

    var imageArray = intArrayOf(R.drawable.cake_image1, R.drawable.beachball,
                                R.drawable.campfire, R.drawable.cherry,
                                R.drawable.genie, R.drawable.michaelmyers,
                                R.drawable.owl, R.drawable.parrot)


    var tempLocation = intArrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        image1 = findViewById(R.id.imageView1)as ImageView
        image2 = findViewById(R.id.imageView2)as ImageView
        image3 = findViewById(R.id.imageView3)as ImageView
        image4 = findViewById(R.id.imageView4)as ImageView
        image5 = findViewById(R.id.imageView5)as ImageView
        image6 = findViewById(R.id.imageView6)as ImageView
        image7 = findViewById(R.id.imageView7)as ImageView
        image8 = findViewById(R.id.imageView8)as ImageView
        image9 = findViewById(R.id.imageView9)as ImageView
        image10 = findViewById(R.id.imageView10)as ImageView
        image11 = findViewById(R.id.imageView11)as ImageView
        image12 = findViewById(R.id.imageView12)as ImageView
        image13 = findViewById(R.id.imageView13)as ImageView
        image14 = findViewById(R.id.imageView14)as ImageView
        image15 = findViewById(R.id.imageView15)as ImageView
        image16 = findViewById(R.id.imageView16)as ImageView




        randomSetImage()
        //4 X 4 = 16 images -> 8 images

    }

    private fun randomSetImage(){

            image1.setImageResource(imageArray[Random().nextInt(8)])
            image2.setImageResource(imageArray[Random().nextInt(8)])
            image3.setImageResource(imageArray[Random().nextInt(8)])
            image4.setImageResource(imageArray[Random().nextInt(8)])
            image5.setImageResource(imageArray[Random().nextInt(8)])
            image6.setImageResource(imageArray[Random().nextInt(8)])
            image7.setImageResource(imageArray[Random().nextInt(8)])
            image8.setImageResource(imageArray[Random().nextInt(8)])
            image9.setImageResource(imageArray[Random().nextInt(8)])
            image10.setImageResource(imageArray[Random().nextInt(8)])
            image11.setImageResource(imageArray[Random().nextInt(8)])
            image12.setImageResource(imageArray[Random().nextInt(8)])
            image13.setImageResource(imageArray[Random().nextInt(8)])
            image14.setImageResource(imageArray[Random().nextInt(8)])
            image15.setImageResource(imageArray[Random().nextInt(8)])
            image16.setImageResource(imageArray[Random().nextInt(8)])
    }

    fun imageArray()
    {
        for(i in 0..15){

        }
    }
}
