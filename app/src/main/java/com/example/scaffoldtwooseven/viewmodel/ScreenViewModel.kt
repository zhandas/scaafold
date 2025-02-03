package com.example.scaffoldtwooseven.viewmodel

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ScreenViewModel: ViewModel() {
    val drawerState = MutableStateFlow(DrawerState(initialValue = DrawerValue.Closed))

    suspend fun toggleState(){
        drawerState.value.apply {
            if (isClosed) open() else close()
        }
    }
}