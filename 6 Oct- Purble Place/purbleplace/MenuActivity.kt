package com.bmpl.purbleplace

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton

class MenuActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var play  = findViewById(R.id.playImageButton) as ImageButton

        var highScore = findViewById(R.id.highScoreImageButton) as ImageButton

        var settings = findViewById(R.id.settingsImageButton) as ImageButton

        play.setOnClickListener{
            var intent = Intent(this, GameActivity :: class.java)
            startActivity(intent)
        }

        highScore.setOnClickListener{
            var intent = Intent(this, HighScoreActivity :: class.java)
            startActivity(intent)
        }

        settings.setOnClickListener{
            var intent = Intent(this, SettingActivity :: class.java)
            startActivity(intent)
        }
    }
}
