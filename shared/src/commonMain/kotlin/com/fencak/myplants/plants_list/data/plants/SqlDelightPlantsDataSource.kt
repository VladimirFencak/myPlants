package com.fencak.myplants.plants_list.data.plants

import com.fencak.myplants.plants_list.domain.plants.PlantItem
import com.fencak.myplants.plants_list.domain.plants.PlantsDataSource
import database.Plant
import database.PlantsQueries

class SqlDelightPlantsDataSource(
    private val queries: PlantsQueries
): PlantsDataSource {

    override suspend fun insertPlant(item: PlantItem) {
        queries.insertPlantEntity(
            imagePath = item.imagePath,
            plantName = item.plantName,
            description = item.description,
            waterAmount = item.waterAmount.toLong(),
            wateringDate = item.wateringDate,
            watered = item.watered.toLong(),
            plantID = item.id
        )
    }
}