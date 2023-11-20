package com.fencak.myplants.plants_list.domain.plants

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil

class IsForgottenPlant() {
    suspend fun execute(plantItem: PlantItem): Boolean {
        val currentDate = Clock.System.now().toEpochMilliseconds()
        val lastWateredDate = plantItem.lastWateredDate ?: plantItem.timestamp

        val currentDateInstant = Instant.fromEpochMilliseconds(currentDate)
        val lastWateredDateInstant = Instant.fromEpochMilliseconds(lastWateredDate)

        val daysDifference = lastWateredDateInstant.daysUntil(currentDateInstant, TimeZone.UTC)

        if(daysDifference >= 1 && plantItem.wateringDay == WateringDay.EVERY_DAY){
            return true
        }

        if(daysDifference >= 7 && plantItem.wateringDay != WateringDay.EVERY_DAY){
            return true
        }

        return false
    }
}