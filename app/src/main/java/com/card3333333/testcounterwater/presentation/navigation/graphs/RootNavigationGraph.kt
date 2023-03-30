package com.card3333333.testcounterwater.presentation.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.card3333333.testcounterwater.presentation.screens.home.HomeScreenContent

@Composable
fun RootNavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Graph.MAIN,
        route = Graph.ROOT
    ){
        mainNavGraph(navHostController)

        composable(route = Graph.HOME) {
            HomeScreenContent(onClick = {
                navHostController.navigate(Graph.ADD)
            })
        }
        addWaterNavGraph(navHostController)
    }
}

object Graph{
    const val MAIN = "main_graph"
    const val ROOT = "root_graph"
    const val HOME = "hone_graph"
    const val ADD = "add_graph"
}