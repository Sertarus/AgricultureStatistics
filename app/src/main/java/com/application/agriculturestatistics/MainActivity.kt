package com.application.agriculturestatistics

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var data =
        arrayOf("Первая конфигурация", "Вторая конфигурация", "Третья конфигурация")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner = findViewById<Spinner>(R.id.spinnerConf)
        spinner.adapter = adapter
        startActivity(Intent(this, ConfigActivity::class.java))
        finish()
    }
}
