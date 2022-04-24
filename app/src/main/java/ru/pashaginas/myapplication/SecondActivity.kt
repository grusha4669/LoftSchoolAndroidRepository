package ru.pashaginas.myapplication

import android.graphics.drawable.Drawable
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button = findViewById(R.id.button)
        button.setOnClickListener(listener)

        var costId = intent.getIntExtra("COST_ID", 0)
        Log.e("TAG", "Cost Id = $costId") //what?
    }
        val listener = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.button -> {
                Toast.makeText(applicationContext, "Button pressed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}