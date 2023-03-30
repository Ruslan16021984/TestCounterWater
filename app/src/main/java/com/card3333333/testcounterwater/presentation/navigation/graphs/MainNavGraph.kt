package com.card3333333.testcounterwater.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.card3333333.testcounterwater.presentation.screens.main.MainScreen
import com.card3333333.testcounterwater.presentation.screens.splash.WaterSplashScreen

fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.MAIN,
        startDestination = NavigationItem.Splash.route
    ) {
        composable(route = NavigationItem.Splash.route) {
            WaterSplashScreen(
                onToMainScreen = {
                    if (it) {
                        navController.navigate(NavigationItem.Main.route)
                    } else {
                        navController.navigate(Graph.HOME)
                    }
                }
            )

        }
        composable(route = NavigationItem.Main.route) {
            MainScreen {
                navController.navigate(Graph.HOME)
            }
        }
    }
}
