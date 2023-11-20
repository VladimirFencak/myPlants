package com.fencak.myplants.plants_list.presentation

import com.fencak.myplants.plants_list.domain.plants.PlantItem

data class PlantsListState(
    val plants: List<PlantItem> = emptyList(),
    val isLoading: Boolean = true,
    val noPlantsFound: Boolean = false,
    val displayState: DisplayState = DisplayState.UPCOMING
)

enum class DisplayState {
    UPCOMING,
    FORGOT_TO_WATER,
    HISTORY
}