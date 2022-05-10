package ru.pashaginas.myapplication.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.pashaginas.myapplication.fragments.FragmentA
import ru.pashaginas.myapplication.fragments.FragmentB
import ru.pashaginas.myapplication.fragments.FragmentC

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> FragmentA()
            1 -> FragmentB()
            2 -> FragmentC()
            else -> {
                throw Resources.NotFoundException("Fragment not found")
            }
        }
    }
}
