package com.card3333333.testcounterwater.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.card3333333.testcounterwater.model.PersonUnit
import com.card3333333.testcounterwater.model.Water

@Database(entities = [PersonUnit::class], version = 1, exportSchema = false)
abstract class WaterDatabase: RoomDatabase() {
    abstract fun waterDatabase(): WaterDatabaseDao
}