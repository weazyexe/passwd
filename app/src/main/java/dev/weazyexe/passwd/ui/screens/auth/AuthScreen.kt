/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.auth

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

const val AUTH_SCREEN_ROUTE = "auth"

@RootNavGraph(start = true)
@Destination(route = AUTH_SCREEN_ROUTE)
@Composable
fun AuthScreen() {
    Text(text = "auth")
}