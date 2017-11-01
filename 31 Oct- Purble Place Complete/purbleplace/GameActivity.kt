package com.bmpl.purbleplace

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import java.util.*

class GameActivity : AppCompatActivity(), View.OnClickListener {

    var animatorSet1 = AnimatorSet()
    var animatorSet2 = AnimatorSet()

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
    var score = 0


    var firstImage = 0
    var secondImage = 0

    private var imageArray = ArrayList<Int>()

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

        image1.setOnClickListener(this)
        image2.setOnClickListener(this)
        image3.setOnClickListener(this)
        image4.setOnClickListener(this)
        image5.setOnClickListener(this)
        image6.setOnClickListener(this)
        image7.setOnClickListener(this)
        image8.setOnClickListener(this)
        image9.setOnClickListener(this)
        image10.setOnClickListener(this)
        image11.setOnClickListener(this)
        image12.setOnClickListener(this)
        image13.setOnClickListener(this)
        image14.setOnClickListener(this)
        image15.setOnClickListener(this)
        image16.setOnClickListener(this)

        animatorSet1 = AnimatorInflater.loadAnimator(this, R.animator.animation_file) as AnimatorSet
        animatorSet2 = AnimatorInflater.loadAnimator(this, R.animator.animation_file) as AnimatorSet


        imageArray.add(R.drawable.cake_image1)
        imageArray.add(R.drawable.beachball)
        imageArray.add(R.drawable.campfire)
        imageArray.add(R.drawable.cherry)
        imageArray.add(R.drawable.genie)
        imageArray.add(R.drawable.michaelmyers)
        imageArray.add(R.drawable.owl)
        imageArray.add(R.drawable.parrot)
        imageArray.add(R.drawable.cake_image1)
        imageArray.add(R.drawable.beachball)
        imageArray.add(R.drawable.campfire)
        imageArray.add(R.drawable.cherry)
        imageArray.add(R.drawable.genie)
        imageArray.add(R.drawable.michaelmyers)
        imageArray.add(R.drawable.owl)
        imageArray.add(R.drawable.parrot)

        Collections.shuffle(imageArray)
        //randomSetImage()
    }

    override fun onClick(view: View?) {

        var handler = Handler()

        when(view?.id)
        {
            R.id.imageView1-> image1.setImageResource(imageArray[0])
            R.id.imageView2-> image2.setImageResource(imageArray[1])
            R.id.imageView3-> image3.setImageResource(imageArray[2])
            R.id.imageView4-> image4.setImageResource(imageArray[3])
            R.id.imageView5-> image5.setImageResource(imageArray[4])
            R.id.imageView6-> image6.setImageResource(imageArray[5])
            R.id.imageView7-> image7.setImageResource(imageArray[6])
            R.id.imageView8-> image8.setImageResource(imageArray[7])
            R.id.imageView9-> image9.setImageResource(imageArray[8])
            R.id.imageView10-> image10.setImageResource(imageArray[9])
            R.id.imageView11-> image11.setImageResource(imageArray[10])
            R.id.imageView12-> image12.setImageResource(imageArray[11])
            R.id.imageView13-> image13.setImageResource(imageArray[12])
            R.id.imageView14-> image14.setImageResource(imageArray[13])
            R.id.imageView15-> image15.setImageResource(imageArray[14])
            R.id.imageView16-> image16.setImageResource(imageArray[15])
        }

        if(firstImage == 0){
            if (view != null) {
                firstImage = view.id
                animatorSet1.setTarget(findViewById(firstImage))
                animatorSet1.start()
            }
        } else if(secondImage == 0){
            if (view != null) {
                secondImage = view.id
                animatorSet2.setTarget(findViewById(secondImage))
                animatorSet2.start()
            }
        }

        if(firstImage!=0 && secondImage!=0){

            handler.postDelayed(Runnable {

                var image1 = findViewById(firstImage) as ImageView
                var image2 = findViewById(secondImage) as ImageView

                var id1 = imageArray[image1.tag.toString().toInt()]
                var id2 = imageArray[image2.tag.toString().toInt()]

                if(image1.resources.getResourceEntryName(id1) == image2.resources.getResourceEntryName(id2))
                {

                    score++
                    Log.i("GameActivity", "Score="+score)
                    firstImage = 0
                    secondImage = 0

                }
                else{
                    animatorSet1.setTarget(image1)
                    animatorSet1.start()

                    animatorSet2.setTarget(image2)
                    animatorSet2.start()

                    image1.setImageResource(R.drawable.leaf)
                    image2.setImageResource(R.drawable.leaf)
                    firstImage = 0
                    secondImage = 0

                }

            }, 1500)
        }
    }
}