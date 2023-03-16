package com.card3333333.testcounterwater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.card3333333.testcounterwater.navigation.graphs.RootNavigationGraph
import com.card3333333.testcounterwater.ui.theme.TestCounterWaterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterApp()
        }
    }
}

@Composable
fun WaterApp() {
    TestCounterWaterTheme {
        RootNavigationGraph(navHostController = rememberNavController())
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestCounterWaterTheme {
    }
}