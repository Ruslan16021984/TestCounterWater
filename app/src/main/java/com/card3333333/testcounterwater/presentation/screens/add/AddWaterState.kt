package com.card3333333.testcounterwater.presentation.screens.add

import com.card3333333.testcounterwater.data.model.Water

data class AddWaterState(
    val isLoading: Boolean,
    val items: List<Water>
){
    companion object {

        fun initial(): AddWaterState {
            return AddWaterState(
                isLoading = false,
                items = emptyList()
            )
        }
    }
}
