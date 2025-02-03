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
fun ScreenTwo(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray) // Установить серый фон для всего экрана
            .padding(16.dp)
    ) {
        // Обложка для надписи "Доброй ночи!"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF424242)), // Темно-серый цвет обложки
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text("Доброй ночи!", color = Color.White, style = MaterialTheme.typography.titleLarge) // Белый текст для контраста
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
        Text("Это экран Два.", color = Color.White) // Установить цвет текста в белый для лучшего контраста
        Text("Ночь — время отдыха и восстановления сил.", color = Color.White)

        Button(onClick = {
            // Переход обратно на экран Один
            navController.navigate("screenOne")
        }) {
            Text("Вернуться на экран Один")
        }
    }
}