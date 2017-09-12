package com.bmpl.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayOfNumbers : IntArray = intArrayOf(1,2,3,
                                        4,5,6,
                                        7,8,9,
                                        10,11,12)

        var arrayOfValues = arrayOf("song1", "song2",
                                    "song3", "song4",
                                    "song5", "song6",
                                    "song7", "song8",
                                    "song9", "song10")

        var arrayAdapter = ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,
                arrayOfValues)

        var mediaplayer : MediaPlayer = MediaPlayer.create(this, R.raw.background_music)

        var play  = findViewById(R.id.playButton)
        var pause = findViewById(R.id.pauseButton)
        var stop = findViewById(R.id.stopButton)

        var listView : ListView = findViewById(R.id.listView) as ListView

        play.setOnClickListener {
            mediaplayer.start()//will play the song
        }
        pause.setOnClickListener {
            mediaplayer.pause()//pause the song
        }
        stop.setOnClickListener {
            mediaplayer.stop()//stop the song
        }

        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(this, "You clicked on "+ arrayOfValues[position], Toast.LENGTH_LONG).show()
        }
    }
}
