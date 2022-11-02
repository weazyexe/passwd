/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import dev.weazyexe.passwd.ui.common.core.PasswdScreenPreview
import dev.weazyexe.passwd.ui.common.theme.PasswdTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthBody(
    login: String,
    password: String,
    onLoginChanged: (String) -> Unit = {},
    onPasswordChanged: (String) -> Unit = {},
) {
    Box {
        TextField(
            value = login,
            onValueChange = onLoginChanged
        )
    }
}

@PasswdScreenPreview
@Composable
private fun AuthBodyPreview() {
    PasswdTheme {
        Surface {
            AuthBody(
                login = "weazyexe",
                password = "qwerty123"
            )
        }
    }
}