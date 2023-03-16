package com.card3333333.testcounterwater.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.card3333333.testcounterwater.model.PersonUnit
import com.card3333333.testcounterwater.repository.WaterDbRepository
import com.card3333333.testcounterwater.utils.dateToDayMounthYear
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddWaterViewModel @Inject constructor(
    private val repository: WaterDbRepository
) : ViewModel() {

    fun updateGenderByConsuming(consuming: String, finish: () -> Unit) =
        viewModelScope.launch {
            val result = repository.getPersonByDate(date = Date.from(Instant.now()).dateToDayMounthYear())
            val consume = result.last().consuming.toInt() + consuming.toInt()
            val item = PersonUnit(
                date = result.last().date,
                gender = result.last().gender,
                weight = result.last().weight,
                target = result.last().target,
                left = result.last().left,
                consuming = consume.toString()
            )
            val id = repository.updateGenderByConsuming(item)
            finish()


        }
}