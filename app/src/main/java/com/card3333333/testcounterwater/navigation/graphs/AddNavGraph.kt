package com.card3333333.testcounterwater.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.card3333333.testcounterwater.screens.add.AddWater

fun NavGraphBuilder.addWaterNavGraph(navHostController: NavHostController) {
    navigation(
        startDestination = NavigationItem.Add.route,
        route = Graph.ADD
    ) {
        composable(route = NavigationItem.Add.route) {
            AddWater(
                onClick = {
                    navHostController.navigate(Graph.HOME)
                }
            )
        }

    }
}