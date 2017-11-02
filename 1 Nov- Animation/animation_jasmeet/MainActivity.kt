package com.bmpl.animation_jasmeet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var animation = AnimationUtils.loadAnimation(this, R.anim.combination_anim)

        button.setOnClickListener {
            imageView.startAnimation(animation)
        }
    }

}
