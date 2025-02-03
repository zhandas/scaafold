package com.example.scaffoldtwooseven.modalsheet

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.scaffoldtwooseven.Provider
import kotlinx.coroutines.CoroutineScope


@Composable
fun ModalSheetTemplate(content: @Composable () -> Unit){
    var drawerState = Provider.viewModel!!.drawerState.collectAsState()
    ModalNavigationDrawer(
        drawerState = drawerState.value,
        drawerContent = {
            ModalDrawerSheet {
                Text("Example")
                Text("Example")
                Text("Example")
                Text("Example")
                Text("Example")
                Text("Example")
                Text("Example")
                Text("Example")
                Text("Example")
            }
        }
    ) {
        content()
    }
}