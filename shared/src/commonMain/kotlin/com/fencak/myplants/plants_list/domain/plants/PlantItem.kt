package com.fencak.myplants.plants_list.domain.plants

data class PlantItem(
    val id: Long?,
    val imagePath: String?,
    val plantName: String,
    val description: String?,
    val waterAmount: Int,
    val wateringDate: Long,
    val watered: Int
)
