package com.application.agriculturestatistics.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.agriculturestatistics.R
import com.application.agriculturestatistics.models.ModelRow
import com.application.agriculturestatistics.models.ModelSector

class SectorAdapter (private val context: Context, val sectorList: ModelRow) : RecyclerView.Adapter<SectorAdapter.MyHolder>() {

    class MyHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView = itemView.findViewById(R.id.sectorName)
        var sectorLayout: LinearLayout = itemView.findViewById(R.id.sectorLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.sownig_sector,
            parent, false
        )
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return sectorList.sector.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val name = sectorList.sector[position].name
        holder.name.text = name
        holder.sectorLayout.setOnClickListener {
            val options = arrayOf(
                "Добавить значение выбранного параметра",
                "Записать мероприятие",
                "Изменить имя сектора"
            )
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Choose action")
            builder.setItems(options) { _, which ->
                when (which) {
                    0 -> {

                    }
                    1 -> {

                    }
                    2 -> {

                    }
                }
            }
            builder.create().show()
        }
    }

}