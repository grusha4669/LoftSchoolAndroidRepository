package ru.pashaginas.myapplication

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
//        if (position == 0) {
//            return FragmentA()
//        } else if (position == 1) {
//            return FragmentB()
//        }
//        return FragmentA()

        return when (position) {
            0 -> FragmentA()
            1 -> FragmentB()
            else -> {
                throw Resources.NotFoundException("Fragment not found")
            }
        }
    }
}
