package com.card3333333.testcounterwater.navigation.graphs

import com.card3333333.testcounterwater.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String){
    object Base: NavigationItem("Base", R.drawable.ic_launcher_foreground, "Base")
    object Home: NavigationItem("Home", R.drawable.ic_launcher_foreground, "Home")
    object History: NavigationItem("History", R.drawable.ic_launcher_foreground, "History")
    object Main: NavigationItem("Main", R.drawable.ic_launcher_foreground, "Main")
    object Splash: NavigationItem("Splash", R.drawable.ic_launcher_foreground, "Splash")
    object Add: NavigationItem("Add", R.drawable.ic_launcher_foreground, "Add")
}
