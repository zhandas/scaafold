package com.example.scaffoldtwooseven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scaffoldtwooseven.screens.MainScreen
import com.example.scaffoldtwooseven.screens.ScreenOne
import com.example.scaffoldtwooseven.screens.ScreenTwo
import com.example.scaffoldtwooseven.ui.theme.ScaffoldTwoOSevenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldTwoOSevenTheme {
                // Установка NavController для навигации между экранами
                val navController = rememberNavController()

                // Навигационный хост
                NavHost(navController = navController, startDestination = "mainScreen") {
                    composable("mainScreen") {
                        MainScreen(navController = navController)
                    }
                    composable("screenOne") {
                        ScreenOne(navController = navController)
                    }
                    composable("screenTwo") {
                        ScreenTwo(navController = navController)
                    }
                }
            }
        }
    }
}