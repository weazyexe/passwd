/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.auth

import dev.weazyexe.passwd.ui.common.core.Effect
import dev.weazyexe.passwd.ui.common.core.State

data class AuthState(
    val login: String = "",
    val password: String = ""
): State

sealed class AuthEffect : Effect
