package com.bmpl.listview_jasmeet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.bmpl.listview_jasmeet.R.id.subListView

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var listView = findViewById(subListView) as ListView

        var array = arrayOf(resources.getStringArray(R.array.Sub_Chapter1),
                resources.getStringArray(R.array.Sub_Chapter2))



        var intent = intent
        var position = intent.getIntExtra("position", 0)

        var arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, array[position])

        listView.adapter = arrayAdapter
    }
}
