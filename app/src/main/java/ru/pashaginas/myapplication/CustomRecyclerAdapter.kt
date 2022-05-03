package ru.pashaginas.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerAdapter(private var names: MutableList<String>) : RecyclerView
.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amount: TextView = itemView.findViewById(R.id.amount)
//        val purpose: TextView = itemView.findViewById(R.id.purpose)
        val purpose: TextView = itemView.findViewById(R.id.purpose)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView  = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.amount.text = names[position]
        holder.purpose.text = names[position]
    }

    override fun getItemCount(): Int {
        return names.size
    }
    // override fun getItemCount() = names.size
}