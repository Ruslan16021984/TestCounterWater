package com.card3333333.testcounterwater.presentation.screens.add.state

data class AddWaterState(
    val update: Boolean
){
    companion object{
        fun initial(): AddWaterState {
            return AddWaterState(
                update = false
            )
        }
    }
}
