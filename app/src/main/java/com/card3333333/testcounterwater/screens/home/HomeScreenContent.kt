package com.card3333333.testcounterwater.screens.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.card3333333.testcounterwater.navigation.graphs.HomeNavGraph
import com.card3333333.testcounterwater.widgets.BottomBar

@Composable
fun HomeScreenContent(
    onClick: ()-> Unit,
    navHostController: NavHostController = rememberNavController(),
) {
    Scaffold(bottomBar ={
        BottomAppBar(
            modifier = Modifier
                .height(65.dp)
                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
            cutoutShape = CircleShape,
            elevation = 22.dp
        ) {
            BottomBar(navHostController)
        }
    },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {
                    onClick()
                },
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Water Icon")
            }
        }) {

        HomeNavGraph(navController = navHostController)
    }
}