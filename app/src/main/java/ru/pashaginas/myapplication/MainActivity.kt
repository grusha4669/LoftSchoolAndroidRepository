package ru.pashaginas.myapplication

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var itemsAdapter: MoneyItemsAdapter
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2


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
        adapter = ViewPagerAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout,viewPager) {tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.fragment_a)
                1 -> getString(R.string.fragment_b)
                else -> {
                    throw Resources.NotFoundException("Fragment not found")
                }
            }

        }.attach()
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
