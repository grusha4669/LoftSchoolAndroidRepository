package ru.pashaginas.myapplication.cells

import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import ru.pashaginas.myapplication.R

class MoneyCellAdapter : RecyclerView.Adapter<MoneyCellAdapter.MoneyViewHolder>() {
    private val moneyItemList: List<MoneyItem> = ArrayList()

    class MoneyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_money, parent, false)
        return MoneyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoneyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return moneyItemList.size
    }
    fun bind(moneyItem: MoneyItem) {

    }
}