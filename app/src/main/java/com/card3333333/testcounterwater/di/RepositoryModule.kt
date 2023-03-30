package com.card3333333.testcounterwater.di

import com.card3333333.testcounterwater.data.repository.WaterDbRepositoryImpl
import com.card3333333.testcounterwater.domain.repository.WaterDbRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun bindRepository(repository: WaterDbRepositoryImpl ): WaterDbRepository
}