package com.card3333333.testcounterwater.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.card3333333.testcounterwater.R
import com.card3333333.testcounterwater.model.Water

@Composable
fun loadWaters() : List<Water>{
return listOf(
    Water(icon = painterResource(id = R.drawable.mug_hot), amount = 250, titleAmount = "250 ml"),
    Water(icon = painterResource(id = R.drawable.water_bottle), amount = 500, titleAmount = "500 ml"),
    Water(icon = painterResource(id = R.drawable.water_bottle), amount = 750, titleAmount = "750 ml"),
    Water(icon = painterResource(id = R.drawable.water_bottle), amount = 1000, titleAmount = "1000 ml"),
    Water(icon = painterResource(id = R.drawable.water_bottle), amount = 1500, titleAmount = "1500 ml"),
    Water(icon = painterResource(id = R.drawable.water_bottle), amount = 2000, titleAmount = "2000 ml"))
}