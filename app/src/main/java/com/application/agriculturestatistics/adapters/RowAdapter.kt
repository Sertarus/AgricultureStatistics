package com.application.agriculturestatistics.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.agriculturestatistics.R
import com.application.agriculturestatistics.models.ModelRow

class RowAdapter (private val context: Context, val rowList: MutableList<ModelRow>) : RecyclerView.Adapter<RowAdapter.MyHolder>() {

    class MyHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView = itemView.findViewById(R.id.rows_recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.sowing_row,
            parent, false
        )
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return rowList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.recyclerView.adapter = SectorAdapter (context, rowList[position])
        holder.recyclerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.setHasFixedSize(true)
    }

}