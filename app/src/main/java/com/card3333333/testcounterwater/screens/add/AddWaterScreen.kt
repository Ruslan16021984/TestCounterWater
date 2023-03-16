package com.card3333333.testcounterwater.screens.add

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.card3333333.testcounterwater.data.loadWaters
import com.card3333333.testcounterwater.widgets.WaterAppBar
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddWater(onClick: ()-> Unit, viewModel: AddWaterViewModel= hiltViewModel()){
    Scaffold(topBar = {
        WaterAppBar(onButtonClicked = {
            Log.e("TAG", "AddWater: ONCLICK", )
            onClick()
        },
        title = "Add Water")
    }) {
        val waterAmount = loadWaters()
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "AddWater", modifier = Modifier.clickable { onClick() })
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(items = waterAmount){item ->
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .clickable {
                                       viewModel.updateGenderByConsuming(
                                           consuming = item.amount.toString()
                                       ){
                                           onClick()
                                       }
                            },
                        backgroundColor = Color(
                            red = Random.nextInt(0, 255),
                            green = Random.nextInt(0, 255),
                            blue = Random.nextInt(0, 255)
                        ),
                        elevation = 2.dp
                    ) {
                        Text(
                            text = item.titleAmount,
                            fontSize = 42.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(24.dp)
                        )
                    }
                }
            }
        }

    }


}