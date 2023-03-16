package com.card3333333.testcounterwater.screens.history

import com.card3333333.testcounterwater.model.PersonUnit

data class HistoryState(
    val isLoading: Boolean,
    val items: List<PersonUnit>
){
    companion object {

        fun initial(): HistoryState {
            return HistoryState(
                isLoading = false,
                items = emptyList()
            )
        }
    }
}
