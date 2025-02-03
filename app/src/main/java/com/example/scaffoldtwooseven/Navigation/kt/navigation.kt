package com.example.scaffoldtwooseven.Navigation.kt

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.scaffoldtwooseven.screens.MainScreen
import com.example.scaffoldtwooseven.screens.ScreenOne
import com.example.scaffoldtwooseven.screens.ScreenTwo


sealed class Screen(val route: String) {
    object Main : Screen("mainScreen")
    object ScreenOne : Screen("screenOne")
    object ScreenTwo : Screen("screenTwo")
}

@Composable
fun SetupNavigation(navController: NavController) {
    NavHost(navController = navController as NavHostController, startDestination = Screen.ScreenOne.route) {
        composable(Screen.Main.route) {
            MainScreen(navController = navController)
            composable(Screen.ScreenOne.route) {
                ScreenOne(navController = navController)
            }
            composable(Screen.ScreenTwo.route) {
                ScreenTwo(navController = navController)
            }
        }
    }
}



