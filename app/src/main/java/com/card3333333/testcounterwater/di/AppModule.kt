package com.card3333333.testcounterwater.di

import android.content.Context
import androidx.room.Room
import com.card3333333.testcounterwater.data.WaterDatabase
import com.card3333333.testcounterwater.data.WaterDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WaterDatabase =
        Room.databaseBuilder(
            context, WaterDatabase::class.java, "water_db"
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideWaterDao(waterDatabase: WaterDatabase): WaterDatabaseDao =
        waterDatabase.waterDatabase()
}