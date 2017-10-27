package com.bmpl.customlistview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.bmpl.customlistview.R.id.listView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById(R.id.listView) as ListView

        listView.adapter = CustomAdapter(this)

    }
}
