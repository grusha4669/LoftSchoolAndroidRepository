package ru.pashaginas.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MoneyItemsAdapter : RecyclerView
.Adapter<MoneyItemsAdapter.MoneyViewHolder>() {

    private var mitems: MutableList<MoneyItem> = mutableListOf()

    class MoneyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amount: TextView = itemView.findViewById(R.id.amount)
        val purpose: TextView = itemView.findViewById(R.id.purpose)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MoneyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoneyViewHolder, position: Int) {
        holder.amount.text = mitems[position].amount.toString()
        holder.purpose.text = mitems[position].purpose
    }

    override fun getItemCount(): Int {
        return mitems.size
    }

    fun addItem(moneyItem: MoneyItem) {
        mitems.add(moneyItem)
        notifyDataSetChanged()
    }
}
