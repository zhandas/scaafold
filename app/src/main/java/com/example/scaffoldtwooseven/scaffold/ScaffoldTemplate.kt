package com.example.scaffoldtwooseven.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.scaffoldtwooseven.Provider
import kotlinx.coroutines.launch

@Composable
fun ScaffoldTemplate(
    title: String,
    floatingActionButtonNeeded: Boolean,
    content: @Composable (PaddingValues) -> Unit
){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(title)
        },
        floatingActionButton =
        {
            if (floatingActionButtonNeeded) FloatingActionButton(onClick = {
                //TODO DO SOMETHING
            }, imageVector = Icons.Default.Add)
        },
        bottomBar = {
            BottomBar()
        }
    ) {
        content(it)
    }
}

@Composable
fun FloatingActionButton(onClick: () -> Unit, imageVector: ImageVector){
    androidx.compose.material3.FloatingActionButton(
        onClick = onClick
    ) {
        Icon(
           imageVector =  imageVector,
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String){
    var isExpanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        Provider.viewModel!!.toggleState()
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(
                onClick = {
                    isExpanded = true
                }
            ) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                DropdownMenu(
                    modifier = Modifier.padding(8.dp),
                    expanded = isExpanded,
                    onDismissRequest = {
                        isExpanded = false
                    }
                ) {
                    Text("Example")
                    Text("Example")
                    Text("Example")
                    Text("Example")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Cyan,
            titleContentColor = Color.Red
        )
    )
}

@Composable
fun BottomBar(){
    BottomAppBar{
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
        }
    }
}