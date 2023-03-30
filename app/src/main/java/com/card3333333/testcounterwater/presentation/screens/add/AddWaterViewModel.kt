package com.card3333333.testcounterwater.presentation.screens.add

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.card3333333.testcounterwater.data.model.PersonUnit
import com.card3333333.testcounterwater.domain.repository.WaterDbRepository
import com.card3333333.testcounterwater.utils.dateToDayMounthYear
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddWaterViewModel @Inject constructor(
    private val repository: WaterDbRepository
) : ViewModel() {

    fun updateGenderByConsuming(consuming: String) =
        viewModelScope.launch {
            val list = repository.getPersonUnits()
            val person = list.filter { person -> person.date == Date.from(Instant.now()).dateToDayMounthYear() }
            if (person.isEmpty()) {
                val person = list.last()
                val item = PersonUnit(
                    date = Date.from(Instant.now()).dateToDayMounthYear(),
                    gender = person.gender,
                    weight = person.weight,
                    target = person.target
                )
                repository.insertUnit(item)
            } else {
                val consume = person.last().consuming.toInt() + consuming.toInt()
                val item = PersonUnit(
                    date = person.last().date,
                    gender = person.last().gender,
                    weight = person.last().weight,
                    target = person.last().target,
                    left = person.last().left,
                    consuming = consume.toString()
                )
                val id = repository.updateGenderByConsuming(item)
                Log.e("TAG", "updateGenderByConsuming: $id", )
            }
        }
}