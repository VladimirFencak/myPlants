package com.fencak.myplants.plants_list.domain.plants

import com.fencak.myplants.core.util.CommonFlow

interface PlantsDataSource {
    suspend fun insertPlant(item: PlantItem)
    fun getPlants(): CommonFlow<List<PlantItem>>
}