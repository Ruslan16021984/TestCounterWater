package com.card3333333.testcounterwater.screens.home

import com.card3333333.testcounterwater.model.PersonUnit

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