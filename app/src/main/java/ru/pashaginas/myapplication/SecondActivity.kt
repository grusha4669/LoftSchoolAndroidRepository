package ru.pashaginas.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

//AddItemActivity
class SecondActivity : AppCompatActivity() {
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener(listener)

        val costId = intent.getIntExtra("COST_ID", 0)
        Log.e("TAG", "Cost Id = $costId") //what?
    }

    private val listener = View.OnClickListener { view ->
        when (view.id) {
            R.id.add_button -> {
                Toast.makeText(applicationContext, R.string.toast, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ThirdActivity::class.java)
                startActivity(intent)
            }
        }
    }
}