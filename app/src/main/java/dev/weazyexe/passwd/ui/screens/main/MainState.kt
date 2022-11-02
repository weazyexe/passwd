/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.main

import dev.weazyexe.passwd.domain.Entry
import dev.weazyexe.passwd.domain.Group
import dev.weazyexe.passwd.ui.common.core.Effect
import dev.weazyexe.passwd.ui.common.core.State

data class MainState(
    val recentEntries: List<Entry> = emptyList(),
    val groups: List<Group> = emptyList()
) : State

sealed class MainEffect : Effect