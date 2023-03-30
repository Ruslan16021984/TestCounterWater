package com.card3333333.testcounterwater.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.card3333333.testcounterwater.presentation.screens.add.AddWaterScreen

fun NavGraphBuilder.addWaterNavGraph(navHostController: NavHostController) {
    navigation(
        startDestination = NavigationItem.Add.route,
        route = Graph.ADD
    ) {
        composable(route = NavigationItem.Add.route) {
            AddWaterScreen(
                onClick = {
                    navHostController.navigate(Graph.HOME)
                }
            )
        }

    }
}