package com.card3333333.testcounterwater.screens.main

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.card3333333.testcounterwater.model.PersonUnit
import com.card3333333.testcounterwater.utils.dateToDayMounthYear
import com.card3333333.testcounterwater.utils.targetOfWater
import com.card3333333.testcounterwater.widgets.SaveButton
import com.card3333333.testcounterwater.widgets.WaterInputText
import java.time.Instant
import java.util.*

@Composable
fun MainScreen(onClick: ()-> Unit
) {
    val viewModel: MainViewModel = hiltViewModel()
    var title by remember {
        mutableStateOf("")
    }
    var gender by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize(),
    color = Color.White) {
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            Text(
                text = "Введите вес",
                style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold)
            WaterInputText(text = title, label = "Weight", onTextChange = {
                                                                       title = it
            },
            modifier = Modifier.padding(top = 9.dp, bottom = 8.dp))
            SaveButton(text = "Save", onClick = {
                if (title.isNotEmpty()){
                    Toast.makeText(context, "Note added", Toast.LENGTH_LONG).show()
                    viewModel.insertUnit(PersonUnit(
                        date = Date.from(Instant.now()).dateToDayMounthYear(),
                        gender = gender,
                        weight = title,
                        target = targetOfWater(
                            weight = title.toInt(),
                            gender = gender,
                            actionMoveTime = 0
                        ).toString()
                    ))
                    onClick()

                }
            })
        }
    }

}
