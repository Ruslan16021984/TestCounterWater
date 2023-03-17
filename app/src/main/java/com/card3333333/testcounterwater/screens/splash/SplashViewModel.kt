package com.card3333333.testcounterwater.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.card3333333.testcounterwater.repository.WaterDbRepository
import com.card3333333.testcounterwater.screens.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: WaterDbRepository
): ViewModel() {

    private val _state = MutableStateFlow(SpashState.initial())
    val state: StateFlow<SpashState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(
                    isLoading = true,
                )
            }
            val result = repository.getPersonUnits()
            _state.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    items = result
                )
            }

        }
    }
}