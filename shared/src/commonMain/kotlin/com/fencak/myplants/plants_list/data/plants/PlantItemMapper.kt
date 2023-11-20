package com.fencak.myplants.plants_list.data.plants

import com.fencak.myplants.plants_list.domain.plants.PlantItem
import com.fencak.myplants.plants_list.domain.plants.toWateringDay
import database.GetPlantsWithLastWateredDate
import database.Plant

fun GetPlantsWithLastWateredDate.toPlantItem(): PlantItem {
    return PlantItem(
        id = plantID,
        imagePath = imagePath,
        plantName = plantName,
        description = description,
        waterAmount = waterAmount.toInt(),
        wateringTime = wateringTime,
        wateringDay = wateringDay.toInt().toWateringDay(),
        lastWateredDate = lastWateredDate?.toInt()
    )
}