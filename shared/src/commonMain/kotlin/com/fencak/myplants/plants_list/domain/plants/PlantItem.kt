package com.fencak.myplants.plants_list.domain.plants

data class PlantItem(
    val id: Long?,
    val imagePath: String?,
    val plantName: String,
    val description: String?,
    val waterAmount: Int,
    val wateringDay: WateringDay,
    val wateringTime: String,
    val lastWateredDate: Long?,
    val timestamp: Long
)

enum class WateringDay {
    EVERY_DAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

fun WateringDay.toInt(): Int {
    return when (this) {
        WateringDay.EVERY_DAY -> 0
        WateringDay.MONDAY -> 1
        WateringDay.TUESDAY -> 2
        WateringDay.WEDNESDAY -> 3
        WateringDay.THURSDAY -> 4
        WateringDay.FRIDAY -> 5
        WateringDay.SATURDAY -> 6
        WateringDay.SUNDAY -> 7
    }
}

fun Int.toWateringDay(): WateringDay {
    return when (this) {
        1 -> WateringDay.MONDAY
        2 -> WateringDay.TUESDAY
        3 -> WateringDay.WEDNESDAY
        4 -> WateringDay.THURSDAY
        5 -> WateringDay.FRIDAY
        6 -> WateringDay.SATURDAY
        7 -> WateringDay.SUNDAY
        else -> WateringDay.EVERY_DAY
    }
}
