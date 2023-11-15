package com.fencak.myplants

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform