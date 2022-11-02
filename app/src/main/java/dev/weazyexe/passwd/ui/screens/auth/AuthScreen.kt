/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

const val AUTH_SCREEN_ROUTE = "auth"

@RootNavGraph(start = true)
@Destination(route = AUTH_SCREEN_ROUTE)
@Composable
fun AuthScreen() {
    val viewModel = hiltViewModel<AuthViewModel>()
    val state by viewModel.uiState.collectAsState()

    AuthBody(login = state.login, password = state.password)
}