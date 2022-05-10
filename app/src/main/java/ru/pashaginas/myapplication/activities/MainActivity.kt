package ru.pashaginas.myapplication.activities

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
import ru.pashaginas.myapplication.MoneyItemDataClass
import ru.pashaginas.myapplication.R
import ru.pashaginas.myapplication.adapters.MoneyItemsAdapter
import ru.pashaginas.myapplication.adapters.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var itemsAdapter: MoneyItemsAdapter
    private lateinit var fab: FloatingActionButton
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    companion object {
        const val RESULT_CODE = 500
    }

    private val fablistener = View.OnClickListener { view ->
        when (view.id) {
            R.id.fab -> {
                val intent = Intent(this, AddItemActivity::class.java)
                startActivityForResult(intent, RESULT_CODE)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.fab)
        fab.setOnClickListener(fablistener)

        //todo rw to fragment class
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView_main)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        itemsAdapter = MoneyItemsAdapter()
        recyclerView.adapter = itemsAdapter

        recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )

        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = viewPagerAdapter

        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout,viewPager) {tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.fragment_a)
                1 -> getString(R.string.fragment_b)
                2 -> getString(R.string.fragment_c)
                else -> {
                    throw Resources.NotFoundException("Fragment not found")
                }
            }
        }.attach()
    }
    //??
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (RESULT_CODE == RESULT_CODE && data != null) {
            itemsAdapter.addItem(
                MoneyItemDataClass(
                    data.getStringExtra(AddItemActivity.KEY_AMOUNT)?: "",
                    data.getStringExtra(AddItemActivity.KEY_PURPOSE) ?: ""
                )
            )
        }

    }
}
