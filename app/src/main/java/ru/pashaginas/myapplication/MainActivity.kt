package ru.pashaginas.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.fab)
        fab.setOnClickListener(fablistener)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        recyclerView.adapter = CustomRecyclerAdapter(fillList())

        recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
        // divider added
    }

    private fun fillList(): MutableList<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("$i item")}
            //todo locale
            return data
        }

        private val fablistener = View.OnClickListener { view ->
            when (view.id) {
                R.id.fab -> {
                    val intent = Intent(this, AddItemActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

