package ru.pashaginas.loftmoney.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.pashaginas.loftmoney.MoneyItemDataClass
import ru.pashaginas.loftmoney.R


class MoneyItemsAdapter : RecyclerView
.Adapter<MoneyItemsAdapter.MoneyViewHolder>() {

    private var mitems: MutableList<MoneyItemDataClass> = mutableListOf()

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

    fun addItem(moneyItemDataClass: MoneyItemDataClass) {
        mitems.add(moneyItemDataClass)
        notifyDataSetChanged()
    }
    fun setList(itemList: List<MoneyItemDataClass>) {
        mitems.clear()
        mitems.addAll(itemList)
        notifyDataSetChanged()
    }
}
