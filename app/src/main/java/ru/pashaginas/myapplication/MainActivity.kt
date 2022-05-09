package ru.pashaginas.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var itemsAdapter: MoneyItemsAdapter
    private lateinit var fab: FloatingActionButton

    companion object {
        const val RCODE = 500
    }

    private val fablistener = View.OnClickListener { view ->
        when (view.id) {
            R.id.fab -> {
                val intent = Intent(this, AddItemActivity::class.java)
                startActivityForResult(intent, RCODE)
            }
        }
    }

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
        itemsAdapter = MoneyItemsAdapter()
        recyclerView.adapter = itemsAdapter

        recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
//        val vp: ViewPager2 = findViewById(R.id.viewpager)
//        vp.adapter = ViewPagerAdapter()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (RCODE == RCODE && data != null) {
            itemsAdapter.addItem(
                MoneyItem(
                    data.getStringExtra(AddItemActivity.KEY_AMOUNT)?.toInt() ?: 0,
                    data.getStringExtra(AddItemActivity.KEY_PURPOSE) ?: ""
                )
            )
        }

    }
}
