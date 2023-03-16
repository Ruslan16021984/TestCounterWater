package com.card3333333.testcounterwater.screens.add

import com.card3333333.testcounterwater.model.Water

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
