package ru.pashaginas.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter : FragmentStateAdapter(FragmentActivity()) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return FragmentA()
        } else if (position == 1) {
            return FragmentA()
        }
        return FragmentA()
    }
}
