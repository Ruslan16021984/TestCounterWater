package com.card3333333.testcounterwater.presentation.screens.home

import com.card3333333.testcounterwater.data.model.PersonUnit

data class HomeState(
    val isLoading: Boolean,
    val items: List<PersonUnit>
) {
    companion object {

        fun initial(): HomeState {
            return HomeState(
                isLoading = false,
                items = emptyList()
            )
        }
    }
}