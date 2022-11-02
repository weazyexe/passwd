/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

const val MAIN_SCREEN_ROUTE = "main"

@RootNavGraph(start = true)
@Destination(route = MAIN_SCREEN_ROUTE)
@Composable
fun MainScreen() {
    val viewModel = hiltViewModel<MainViewModel>()
    val state by viewModel.uiState.collectAsState()

    MainBody(
        recentEntries = state.recentEntries,
        groups = state.groups,
        onGroupClick = {  }
    )
}