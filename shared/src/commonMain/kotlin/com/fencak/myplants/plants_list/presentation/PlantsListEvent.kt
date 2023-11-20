package com.fencak.myplants.plants_list.presentation

import com.fencak.myplants.plants_list.domain.plants.PlantItem

sealed class PlantsListEvent {
    data object ShowUpcoming : PlantsListEvent()
    data object ShowForgotToWater : PlantsListEvent()
    data object ShowHistory : PlantsListEvent()
    data object AddNewPlant : PlantsListEvent()
    data class PlantClicked(val plant: PlantItem) : PlantsListEvent()
}