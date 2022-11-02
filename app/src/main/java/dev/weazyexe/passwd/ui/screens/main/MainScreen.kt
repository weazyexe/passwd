/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination

const val MAIN_SCREEN_ROUTE = "main"

@Destination(route = MAIN_SCREEN_ROUTE)
@Composable
fun MainScreen() {
    Text(text = "main")
}