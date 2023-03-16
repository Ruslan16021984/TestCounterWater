package com.card3333333.testcounterwater.screens.history

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.card3333333.testcounterwater.R
import com.card3333333.testcounterwater.data.loadWaters
import com.card3333333.testcounterwater.model.PersonUnit
import com.card3333333.testcounterwater.screens.main.MainStateEvent
import com.card3333333.testcounterwater.screens.main.MainViewModel
import com.card3333333.testcounterwater.widgets.WaterAppBar
import de.palm.composestateevents.EventEffect

@Composable
fun HistoryScreen(
    mainViewModel: HistoryViewModel = hiltViewModel()){

    val state by mainViewModel.state.collectAsState()
    val listOfAmountWater = remember {
        mutableStateListOf<PersonUnit>()
    }
    val noteList = state.items
    Scaffold() {
        Surface(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                LazyColumn{
                    items(items = noteList){
                        Log.e("TAG", "items:$noteList " )
                        WaterRow(it)
                    }

                }
            }
        }
    }


}
@Composable
fun WaterRow(water: PersonUnit){
    Surface(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(50.dp),
        shape = CircleShape.copy(topEnd = CornerSize(6.dp)),
        color = Color(0xFFB2DFDB)
    ) {
        Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(
                    id = R.drawable.mug_alt),
                    contentDescription = "cup Icon",
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                        )
                        .size(30.dp),
                    tint = Color.DarkGray.copy(alpha = 0.7f))

                Text(text = water.consuming, modifier = Modifier.padding(start = 8.dp))
            }
            Row {
                Text(text = water.date,
                modifier = Modifier.padding(end = 16.dp))
            }


        }
    }
}