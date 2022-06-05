package ru.pashaginas.loftmoney.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.pashaginas.loftmoney.R
import ru.pashaginas.loftmoney.fragments.BudgetFragment
import ru.pashaginas.loftmoney.fragments.BalanceFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> BudgetFragment.newInstance(R.color.green, "income")
            1 -> BudgetFragment.newInstance(R.color.blue, "expense")
            2 -> BalanceFragment()
            else -> {
                throw Resources.NotFoundException("Fragment not found")
            }
        }
    }
}
