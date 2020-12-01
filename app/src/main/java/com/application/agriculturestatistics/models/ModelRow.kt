package com.application.agriculturestatistics.models

data class ModelRow(
    var number: Int = 0, var sector: MutableList<ModelSector> = mutableListOf()
)