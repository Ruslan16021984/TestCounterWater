package com.card3333333.testcounterwater.repository

import com.card3333333.testcounterwater.data.WaterDatabaseDao
import com.card3333333.testcounterwater.model.PersonUnit
import com.card3333333.testcounterwater.model.Water
import kotlinx.coroutines.flow.Flow
import java.time.Instant
import java.util.Date
import javax.inject.Inject

class WaterDbRepository @Inject constructor(
    private val waterDatabaseDao: WaterDatabaseDao
) {

    //PersonUnit
    fun getUnits(): Flow<List<PersonUnit>> = waterDatabaseDao.getGenderUnits()
    suspend fun insertUnit(unit: PersonUnit) = waterDatabaseDao.insertGenderUnit(unit)
   suspend fun updateGenderByConsuming(item: PersonUnit) =
        waterDatabaseDao.updateGenderByConsuming(item)
   suspend fun getPersonByDate(date: String) = waterDatabaseDao.getPersonUnitByDate(date)
    suspend fun deleteAllUnits() = waterDatabaseDao.deleteAllPersonUnits()
    suspend fun deleteUnit(unit: PersonUnit) = waterDatabaseDao.deletePersonUnit(unit)
}