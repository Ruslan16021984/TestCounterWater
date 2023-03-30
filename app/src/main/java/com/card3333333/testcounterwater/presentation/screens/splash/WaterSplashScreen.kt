package com.card3333333.testcounterwater.presentation.screens.splash

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.card3333333.testcounterwater.R
import com.card3333333.testcounterwater.presentation.screens.main.MainStateEvent
import com.card3333333.testcounterwater.presentation.screens.main.MainViewModel
import de.palm.composestateevents.EventEffect
import kotlinx.coroutines.delay

@OptIn(ExperimentalLifecycleComposeApi::class)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun WaterSplashScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onToMainScreen: (Boolean) -> Unit
) {
    val scale = remember {
        Animatable(0f)
    }
    val start = remember {
        mutableStateOf(false)
    }
    val viewState: MainStateEvent by viewModel.viewState.collectAsStateWithLifecycle()
    viewModel.startProcess()
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                }
            )
        )
        delay(2000L)
        start.value = true

    })
    if (start.value){
        EventEffect(
            event = viewState.downloadGendersEvent,
            onConsumed = viewModel::onConsumedDownloadSucceededEvents
        ) { result ->
            if (result.isEmpty()){
                onToMainScreen(true)
            }else{
                onToMainScreen(false)
            }

        }
    }

    Surface(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
            .scale(scale.value),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(width = 2.dp, color = Color.LightGray),
    ) {
        Column(
            modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.mug_hot
                ),
                contentDescription = "Icon Cup",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(65.dp)
            )
            Text(
                text = "Water consumption calculator",
                style = MaterialTheme.typography.h5,
                color = Color.Gray
            )
        }

    }
}