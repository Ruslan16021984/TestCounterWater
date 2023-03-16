package com.card3333333.testcounterwater.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.card3333333.testcounterwater.screens.main.MainScreen
import com.card3333333.testcounterwater.screens.splash.WaterSplashScreen

fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.MAIN,
        startDestination = NavigationItem.Splash.route
    ) {
        composable(route = NavigationItem.Splash.route) {
            WaterSplashScreen(
                onFinishedAnimation = {
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
