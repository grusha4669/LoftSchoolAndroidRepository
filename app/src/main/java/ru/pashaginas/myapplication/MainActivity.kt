package ru.pashaginas.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ShareCompat
import java.nio.file.attribute.AclFileAttributeView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun tapScreen(view: View) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("COST_ID", 1)
        startActivity(intent)

//        setContentView(R.layout.activity_second)
        // shows second screen if main screen was tapped
    }
}