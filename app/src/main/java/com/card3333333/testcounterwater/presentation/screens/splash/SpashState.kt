package com.card3333333.testcounterwater.presentation.screens.splash

import com.card3333333.testcounterwater.data.model.PersonUnit

data class SpashState(
    val isLoading: Boolean,
    val items: List<PersonUnit>
) {
    companion object {

        fun initial(): SpashState {
            return SpashState(
                isLoading = false,
                items = emptyList()
            )
        }
    }
}
