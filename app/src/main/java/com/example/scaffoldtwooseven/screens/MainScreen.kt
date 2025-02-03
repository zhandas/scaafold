package com.example.scaffoldtwooseven.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Навигация") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)) {
            Text("Добро пожаловать! Выберите экран для навигации:")

            // Кнопка для перехода на ScreenOne
            Button(onClick = {
                navController.navigate("screenOne")
            }) {
                Text("Перейти на экран Один")
            }

            Spacer(modifier = Modifier.height(16.dp)) // Пробел между кнопками

            // Кнопка для перехода на ScreenTwo
            Button(onClick = {
                navController.navigate("screenTwo")
            }) {
                Text("Перейти на экран Два")
            }
        }
    }
}