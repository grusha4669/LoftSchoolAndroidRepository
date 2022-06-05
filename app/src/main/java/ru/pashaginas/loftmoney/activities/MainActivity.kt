package ru.pashaginas.loftmoney.activities

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.pashaginas.loftmoney.R
import ru.pashaginas.loftmoney.adapters.ViewPagerAdapter

class MainActivity : AppCompatActivity() {


    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var fab: FloatingActionButton
    private var fragmentType: String? = null
    private var currentFragmentPosition: Int? = null

    private val fablistener = View.OnClickListener { view ->
        when (view.id) {
            R.id.fab -> {
                if (currentFragmentPosition == 0) {
                    fragmentType = "income"
                } else if (currentFragmentPosition == 1) {
                    fragmentType = "expense"
                }

                val intent = Intent(this, AddItemActivity::class.java)
                intent.putExtra(FRAGMENT_TYPE, fragmentType)
                startActivity(intent)
            }
        }
    }


    companion object {
        const val FRAGMENT_TYPE = "FragmentType"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = viewPagerAdapter
        fab = findViewById(R.id.fab)
        fab.setOnClickListener(fablistener)
        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.fragment_a)
                1 -> getString(R.string.fragment_b)
                2 -> getString(R.string.fragment_c)
                else -> {
                    throw Resources.NotFoundException("Fragment not found")
                }
            }
        }.attach()
        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentFragmentPosition = position
                if (position == 2) fab.hide() else fab.show()
            }
        })
    }
}
