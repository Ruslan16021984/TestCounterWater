package com.card3333333.testcounterwater.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_tbl")
data class PersonUnit(
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "water_drunk_date")
    val date: String,

    @ColumnInfo(name = "gender")
    val gender: Boolean,

    @ColumnInfo(name = "weight")
    val weight: String,


    @ColumnInfo(name = "water_target")
    val target: String = "0",

    @ColumnInfo(name = "water_left")
    val left: String = "0",

    @ColumnInfo(name = "water_consuming")
    val consuming: String = "0"
)