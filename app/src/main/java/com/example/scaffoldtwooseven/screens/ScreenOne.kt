package com.example.scaffoldtwooseven.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ScreenOne(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow) // Установить желтый фон для всего экрана
            .padding(16.dp)
    ) {
        // Обложка для надписи "Доброе утро!"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFA500)), // Оранжевый цвет
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text("Доброе утро!", color = Color.Black, style = MaterialTheme.typography.titleLarge)
                }
            }

            // Иконка дома для возврата на главный экран
            IconButton(
                onClick = {
                    navController.navigate("mainScreen") {
                        popUpTo("mainScreen") { inclusive = true } // Удалить все предыдущие экраны из стека
                    }
                },
                modifier = Modifier
                    .align(Alignment.TopEnd) // Выравнивание иконки по правому верхнему углу
                    .padding(16.dp) // Отступ для иконки
            ) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "Вернуться на главный экран")
            }
        }

        // Остальное содержимое экрана
        Text("Это экран Один.")
        Text("Утро — время новых начинаний и возможностей.")
        Button(onClick = {
            // Переход на экран Два
            navController.navigate("screenTwo")
        }) {
            Text("Перейти на экран Два")
        }
    }
}