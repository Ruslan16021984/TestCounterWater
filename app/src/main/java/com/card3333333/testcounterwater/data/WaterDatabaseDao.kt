package com.card3333333.testcounterwater.data

import androidx.room.*
import com.card3333333.testcounterwater.model.PersonUnit
import com.card3333333.testcounterwater.model.Water
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface WaterDatabaseDao {

    //genderUnit
    @Query("SELECT * FROM person_tbl")
    fun getGenderUnits(): Flow<List<PersonUnit>>

    @Query("SELECT * FROM person_tbl WHERE water_drunk_date =:date")
   suspend fun getPersonUnitByDate(date: String): List<PersonUnit>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenderUnit(unit: PersonUnit)

//    @Query("UPDATE person_tbl SET water_consuming = :waterConsuming WHERE water_drunk_date = :date")
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateGenderByConsuming(item: PersonUnit): Int

    @Query("DELETE FROM person_tbl")
    suspend fun deleteAllPersonUnits()

    @Delete
    suspend fun deletePersonUnit(unit: PersonUnit)

}