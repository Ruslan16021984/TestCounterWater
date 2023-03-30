package com.card3333333.testcounterwater.presentation.screens.main

import com.card3333333.testcounterwater.data.model.PersonUnit
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed

data class MainStateEvent(
    val isLoadingGender: Boolean = false,
    val downloadGendersEvent: StateEventWithContent< List<PersonUnit>> = consumed(),
)