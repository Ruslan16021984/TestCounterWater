package com.card3333333.testcounterwater.domain.repository

import com.card3333333.testcounterwater.data.model.PersonUnit
import kotlinx.coroutines.flow.Flow

interface WaterDbRepository {

    //PersonUnit
    fun getUnits(): Flow<List<PersonUnit>>
    suspend fun getPersonUnits(): List<PersonUnit>
    suspend fun insertUnit(unit: PersonUnit)
    suspend fun updateGenderByConsuming(item: PersonUnit): Int

    suspend fun getPersonByDate(date: String): List<PersonUnit>
    suspend fun deleteAllUnits()
    suspend fun deleteUnit(unit: PersonUnit)
}