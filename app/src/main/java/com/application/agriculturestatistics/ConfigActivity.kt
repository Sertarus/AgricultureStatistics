package com.application.agriculturestatistics

import android.app.AlertDialog
import android.os.Bundle
import android.os.RecoverySystem
import android.view.Display
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.agriculturestatistics.adapters.RowAdapter
import com.application.agriculturestatistics.adapters.SectorAdapter
import com.application.agriculturestatistics.models.ModelRow
import com.application.agriculturestatistics.models.ModelSector

class ConfigActivity : AppCompatActivity() {
    var data =
        arrayOf("Влажность", "Кислотность", "Содержание магния")
    val options = arrayOf(
        "Добавить новый параметр",
        "Включить цветовую индикацию",
        "Выгрузить в Excel"
    )
    var sectors = mutableListOf(
        ModelRow(
            1, mutableListOf(
                ModelSector(
                    "Помидоры",
                    1
                ), ModelSector("Помидоры2", 2),
                ModelSector("Помидоры3", 3), ModelSector("помидоры4", 4)
            )
        ), ModelRow(
            2,
            mutableListOf(
                ModelSector("Лук", 1),
                ModelSector("Лук2", 2), ModelSector("Лук3", 3)
            )
        ),
        ModelRow(
            3, mutableListOf(
                ModelSector("Картофель", 1),
                ModelSector("Картофель2", 2),
                ModelSector("Картофель3", 3)
            )
        )
    )
    var sectorColors = mutableListOf("b", "b", "b", "b", "b", "b", "b", "b", "b", "b")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.configuration_activity)
        setTitle("Первая конфигурация")
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner = findViewById<Spinner>(R.id.spinnerParam)
        spinner.adapter = adapter
        val recyclerView = findViewById<RecyclerView>(R.id.sectors_recyclerView)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.stackFromEnd = true
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        val adapterSector = RowAdapter(this@ConfigActivity, sectors, sectorColors)
        recyclerView.adapter = adapterSector
        val optionButton = findViewById<ImageButton>(R.id.optionButton)
        optionButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Выберите действие")
            builder.setItems(options) { _, which ->
                when (which) {
                    0 -> {

                    }
                    1 -> {
                        sectorColors = mutableListOf("y", "g", "y", "r", "r", "g", "y", "y", "g", "g")
                        val adapterSector = RowAdapter(this@ConfigActivity, sectors, sectorColors)
                        recyclerView.adapter = adapterSector
                    }
                    2 -> {

                    }
                }
            }
            builder.create().show()
        }
    }
}
