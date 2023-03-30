package com.card3333333.testcounterwater.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.card3333333.testcounterwater.data.model.PersonUnit
import com.card3333333.testcounterwater.domain.repository.WaterDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WaterDbRepository
) : ViewModel() {
    private val _stateStream  = MutableStateFlow(
        MainStateEvent()
    )
    val viewState = _stateStream.asStateFlow()

    fun startProcess(){
        viewModelScope.launch {
            _stateStream.update { currentState -> currentState.copy(isLoadingGender = true) }
            repository.getUnits().collect { result->
                _stateStream.update { currentState ->
                    currentState.copy(
                        downloadGendersEvent = triggered(result),
                        isLoadingGender = false
                    )
                }
            }
        }
    }

    fun onConsumedDownloadSucceededEvents() {
        _stateStream.update { currentState ->
            currentState.copy(
                downloadGendersEvent = consumed()
            )
        }
    }

    fun insertUnit(unit: PersonUnit) =
        viewModelScope.launch { repository.insertUnit(unit) }

}
