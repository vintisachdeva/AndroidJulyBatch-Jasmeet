package com.bmpl.purbleplace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Handler class--> Android
        val delay : Long = 3000

        var handler = Handler()

        var run = Runnable {
            var intent = Intent(this, MenuActivity :: class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(run,delay)
    }
}

