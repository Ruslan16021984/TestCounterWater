package com.card3333333.testcounterwater.presentation.screens.add

import com.card3333333.testcounterwater.data.model.Water

data class AddWaterState(
    val updateValue: Boolean
){
    companion object {

        fun initial(): AddWaterState {
            return AddWaterState(
                updateValue = false
            )
        }
    }
}
