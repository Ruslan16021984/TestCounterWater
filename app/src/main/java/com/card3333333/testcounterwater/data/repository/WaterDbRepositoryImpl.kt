package com.card3333333.testcounterwater.data.repository

import com.card3333333.testcounterwater.data.WaterDatabaseDao
import com.card3333333.testcounterwater.data.model.PersonUnit
import com.card3333333.testcounterwater.domain.repository.WaterDbRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WaterDbRepositoryImpl  @Inject constructor(
    private val waterDatabaseDao: WaterDatabaseDao
): WaterDbRepository {
    override fun getUnits(): Flow<List<PersonUnit>> = waterDatabaseDao.getGenderUnits()
    override suspend fun getPersonUnits(): List<PersonUnit> = waterDatabaseDao.getPersonUnits()
    override suspend fun insertUnit(unit: PersonUnit) = waterDatabaseDao.insertGenderUnit(unit)
    override suspend fun updateGenderByConsuming(item: PersonUnit) =
        waterDatabaseDao.updateGenderByConsuming(item)

    override suspend fun getPersonByDate(date: String) = waterDatabaseDao.getPersonUnitByDate(date)
    override suspend fun deleteAllUnits() = waterDatabaseDao.deleteAllPersonUnits()
    override suspend fun deleteUnit(unit: PersonUnit) = waterDatabaseDao.deletePersonUnit(unit)
}