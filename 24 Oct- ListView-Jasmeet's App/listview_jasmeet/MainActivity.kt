package com.bmpl.listview_jasmeet

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.bmpl.listview_jasmeet.R.id.listView

class MainActivity : AppCompatActivity() {

    var array = arrayOf("Chapter 1" ,"Chapter 2" ,"Chapter 3", "Chapter 4",
            "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9",
            "Chapter 10", "Chapter 11", "Chapter 12", "Chapter 13", "Chapter 14",
            "Chapter 15", "Chapter 16", "Chapter 17", "Chapter 18")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById(listView) as ListView

        var arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, array)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { adapterView, view, index, l ->

            var intent = Intent(this, SubActivity :: class.java)
            intent.putExtra("position", index)
            startActivity(intent)
            //Toast.makeText(this, "You clicked on "+ array[index], 1000).show()
        }
    }
}
