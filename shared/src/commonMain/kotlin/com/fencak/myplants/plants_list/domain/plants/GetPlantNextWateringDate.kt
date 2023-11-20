package com.fencak.myplants.plants_list.domain.plants

import kotlinx.datetime.Clock

class GetPlantNextWateringDate(
    private val plantsDataSource: PlantsDataSource
) {
    suspend fun execute(plantItem: PlantItem) {
        val actualDate = Clock.System.now().toEpochMilliseconds()
    }
}