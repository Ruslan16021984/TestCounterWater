package com.card3333333.testcounterwater.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.card3333333.testcounterwater.screens.main.MainStateEvent
import com.card3333333.testcounterwater.screens.main.MainViewModel
import com.card3333333.testcounterwater.ui.theme.gray
import com.card3333333.testcounterwater.ui.theme.orange
import com.card3333333.testcounterwater.utils.percentageFromCount
import com.card3333333.testcounterwater.widgets.CustomCircularProgressIndicator
import de.palm.composestateevents.EventEffect

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val viewStateGender: MainStateEvent by mainViewModel.viewState.collectAsStateWithLifecycle()
    mainViewModel.startProcess()
    val target = remember {
        mutableStateOf("")
    }
    val left = remember {
        mutableStateOf("")
    }
    val consuming = remember {
        mutableStateOf("120")
    }

    EventEffect(
        event = viewStateGender.downloadGendersEvent,
        onConsumed = mainViewModel::onConsumedDownloadSucceededEvents
    ) { result ->
        target.value = result.last().target
        consuming.value = result.last().consuming
        if (result.last().left == "0"){
            left.value = target.value
        }else{
            left.value = result.last().left
        }

    }
    Column(modifier = Modifier.fillMaxWidth()) {
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (target.value.isNotEmpty()) {

            CustomCircularProgressIndicator(
                modifier = Modifier
                    .size(350.dp),
                percentage = percentageFromCount((target.value).toInt(), consuming.value.toInt()),
                target = target.value.toInt(),
                left = left.value,
                consuming = consuming.value,
                primaryColor = orange,
                secondaryColor = gray,
                circleRadius = 350f
            )
        }


    }
}