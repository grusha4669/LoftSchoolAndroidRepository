package ru.pashaginas.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClick(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

}