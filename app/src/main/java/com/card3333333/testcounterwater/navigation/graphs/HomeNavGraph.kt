package com.card3333333.testcounterwater.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.card3333333.testcounterwater.screens.history.HistoryScreen
import com.card3333333.testcounterwater.screens.home.HomeScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route,
        route = Graph.HOME
    ) {
        composable(route = NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(route = NavigationItem.History.route) {
            HistoryScreen()
        }
        addWaterNavGraph(navHostController = navController)
    }
}
