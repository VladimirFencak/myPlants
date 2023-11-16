package com.fencak.myplants.plants_list.data.plants

import com.fencak.myplants.plants_list.domain.plants.PlantItem
import database.Plant

fun Plant.toPlantItem(): PlantItem {
    return PlantItem(
        id = plantID,
        imagePath = imagePath,
        plantName = plantName,
        description = description,
        waterAmount = waterAmount.toInt(),
        wateringDate = wateringDate,
        watered = watered.toInt()
    )
}