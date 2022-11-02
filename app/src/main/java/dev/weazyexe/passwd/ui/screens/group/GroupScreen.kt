/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.group

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination

const val GROUP_SCREEN_ROUTE = "group"

@Destination(route = GROUP_SCREEN_ROUTE)
@Composable
fun GroupScreen() {
    Text(text = "group")
}