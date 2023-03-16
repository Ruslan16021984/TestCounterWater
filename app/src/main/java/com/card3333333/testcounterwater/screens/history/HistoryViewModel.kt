package com.card3333333.testcounterwater.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.card3333333.testcounterwater.repository.WaterDbRepository
import com.card3333333.testcounterwater.screens.add.AddWaterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: WaterDbRepository
): ViewModel() {
    private val _state = MutableStateFlow(HistoryState.initial())
    val state: StateFlow<HistoryState> = _state.asStateFlow()
    init {
        viewModelScope.launch {
            repository.getUnits().collect{
                _state.update {currentState ->
                    currentState.copy(
                        isLoading = false,
                        items = it
                    )
                }
            }
        }
    }
}