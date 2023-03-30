package com.card3333333.testcounterwater.presentation.screens.history

import com.card3333333.testcounterwater.data.model.PersonUnit

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
