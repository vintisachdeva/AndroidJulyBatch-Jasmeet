package com.bmpl.fetchinginternalsongs

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var arrayList: ArrayList<HashMap<String, String>>
    lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        arrayList = ArrayList()

        getSongs()

        val listAdapter = SimpleAdapter(this, arrayList, R.layout.custom_layout, arrayOf("title"), intArrayOf(R.id.textView))

        listView.adapter = listAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val uri = Uri.parse(arrayList[i]["path"])

            mediaPlayer = MediaPlayer.create(this@MainActivity, uri)
            mediaPlayer.start()
        }

    }

    fun getSongs()
    {

        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI   // Internal URI(Built-in music) or External URI(User Downloaded data)

        val musicFiles = MediaStore.Audio.Media.IS_MUSIC + " != 0"

        val order = MediaStore.Audio.Media.TITLE + " ASC"

        val contentResolver = this.contentResolver

        val cursor = contentResolver.query(uri, null, musicFiles, null, order)



        if (cursor != null) {
            while (cursor.moveToNext()) {
                // 1 song --> arraylist --> 0 index 1 index
                val title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                val path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))// path of song

                //arrayList.add(new SongData(title, path));

                val hashMap = HashMap<String,String>()
                //
                hashMap.put("title", title)
                hashMap.put("path", path)


                Log.i("MainActivity", "title= " + title)
                Log.i("MainActivity", "path= " + path)

                arrayList.add(hashMap)

            }
        }

    }
}