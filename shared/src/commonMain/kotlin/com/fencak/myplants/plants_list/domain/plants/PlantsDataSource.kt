package com.fencak.myplants.plants_list.domain.plants

interface PlantsDataSource {
    suspend fun insertPlant(item: PlantItem)
}