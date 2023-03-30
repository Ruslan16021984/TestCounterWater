package com.card3333333.testcounterwater.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.card3333333.testcounterwater.presentation.ui.theme.gray
import com.card3333333.testcounterwater.presentation.ui.theme.orange
import com.card3333333.testcounterwater.utils.percentageFromCount
import com.card3333333.testcounterwater.presentation.widgets.CustomCircularProgressIndicator

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val viewState by homeViewModel.state.collectAsState()
    val target = remember {
        mutableStateOf("")
    }
    val left = remember {
        mutableStateOf("")
    }

    val consuming = remember {
        mutableStateOf("120")
    }
    if (!viewState.isLoading){
        target.value = viewState.items.last().target
        consuming.value = viewState.items.last().consuming
        if (viewState.items.last().left == "0"){
            left.value = target.value
        }else{
            left.value = viewState.items.last().left
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

}