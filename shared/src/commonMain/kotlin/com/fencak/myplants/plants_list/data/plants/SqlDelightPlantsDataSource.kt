package com.fencak.myplants.plants_list.data.plants

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.fencak.myplants.core.util.CommonFlow
import com.fencak.myplants.core.util.toCommonFlow
import com.fencak.myplants.plants_list.domain.plants.PlantItem
import com.fencak.myplants.plants_list.domain.plants.PlantsDataSource
import com.fencak.myplants.plants_list.domain.plants.toInt
import database.PlantsQueries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map

class SqlDelightPlantsDataSource(
    private val queries: PlantsQueries
) : PlantsDataSource {

    override suspend fun insertPlant(item: PlantItem) {
        queries.insertPlantEntity(
            plantID = item.id,
            imagePath = item.imagePath,
            plantName = item.plantName,
            description = item.description,
            waterAmount = item.waterAmount.toLong(),
            wateringDay = item.wateringDay.toInt().toLong(),
            wateringTime = item.wateringTime,
        )
    }

    override fun getPlants(): CommonFlow<List<PlantItem>> {
        return queries.getPlantsWithLastWateredDate()
            .asFlow()
            .mapToList(Dispatchers.Main)
            .map { plant ->
                plant.map { it.toPlantItem() }
            }
            .toCommonFlow()
    }

}