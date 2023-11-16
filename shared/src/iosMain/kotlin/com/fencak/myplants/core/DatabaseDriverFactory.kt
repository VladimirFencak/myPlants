package com.fencak.myplants.core

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.fencak.myplants.database.PlantsDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(PlantsDatabase.Schema,  "translate.db")
    }
}