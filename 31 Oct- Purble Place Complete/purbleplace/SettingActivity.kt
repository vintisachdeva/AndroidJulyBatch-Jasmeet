package com.bmpl.purbleplace

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CompoundButton
import android.widget.ToggleButton
import com.bmpl.purbleplace.R.id.backgroundMusicToggle

class SettingActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        var backgroundToggleButton = findViewById(backgroundMusicToggle) as ToggleButton
        var musicToggleButton = findViewById(backgroundMusicToggle) as ToggleButton

        backgroundToggleButton.setOnCheckedChangeListener(this)
        musicToggleButton.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {

    }

}
