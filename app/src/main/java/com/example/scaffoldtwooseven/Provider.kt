package com.example.scaffoldtwooseven

import com.example.scaffoldtwooseven.viewmodel.ScreenViewModel

object Provider {
    var viewModel: ScreenViewModel? = null

    fun provide(viewModel: ScreenViewModel){
        this.viewModel = viewModel
    }
}