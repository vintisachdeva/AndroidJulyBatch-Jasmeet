package com.bmpl.musicappdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var isPlaying : Boolean = false

    var songArray = arrayOf("song1", "song2", "song3", "song4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView : TextView = findViewById(R.id.currentDetailsTextView) as TextView

        var playPauseButton : ImageButton = findViewById(R.id.playPauseButton) as ImageButton

        var listView : ListView = findViewById(R.id.listView) as ListView

        var arrayAdapter= ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, songArray)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { _, _, i, _ ->
            textView.text = songArray[i]
        }

        playPauseButton.setOnClickListener {
            if(isPlaying)
                playPauseButton.setImageResource(android.R.drawable.ic_media_pause)
            else
                playPauseButton.setImageResource(android.R.drawable.ic_media_play)

            isPlaying=!isPlaying
        }

    }
}
