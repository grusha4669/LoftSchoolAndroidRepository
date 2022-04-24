package ru.pashaginas.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.media.MediaPlayer
import android.widget.Button
import android.widget.Toast

var mPlayer: MediaPlayer? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPlayer = MediaPlayer.create(this, R.raw.imperial_march)
        mPlayer!!.isLooping = true
        mPlayer!!.start()
    }
    fun tapScreen(view: View) {
        val intent = Intent(this,SecondActivity::class.java,)
        intent.putExtra("COST_ID", 1)
        startActivity(intent)
        mPlayer!!.stop()
        mPlayer = MediaPlayer.create(this, R.raw.nodarthvader)
        mPlayer!!.start()
    }
}