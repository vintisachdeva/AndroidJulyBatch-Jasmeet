package com.bmpl.purbleplace

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class BackgroundMusic : Service() {

    var backgroundMusic = MediaPlayer()

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //initialization work
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        backgroundMusic = MediaPlayer.create(this, R.raw.background_music)
        backgroundMusic.start()
        backgroundMusic.isLooping = true
        Log.i("BackgroundMusic", "Music Started")
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        Log.i("BackgroundMusic", "Music Destroyed")
        super.onDestroy()
        backgroundMusic.stop()
    }
}