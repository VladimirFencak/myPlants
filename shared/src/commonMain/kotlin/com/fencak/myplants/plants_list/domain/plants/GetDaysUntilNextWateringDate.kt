package com.fencak.myplants.plants_list.domain.plants

import kotlinx.datetime.Clock
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetDaysUntilNextWateringDate(
    private val plantsDataSource: PlantsDataSource
) {
    suspend fun execute(plantItem: PlantItem): Int {
        val actualDate = Clock.System.now().toLocalDateTime(TimeZone.UTC)

        return (DayOfWeek.MONDAY.ordinal - actualDate.dayOfWeek.ordinal + 7) % 7
    }
}