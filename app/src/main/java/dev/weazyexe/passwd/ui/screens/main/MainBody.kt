/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.weazyexe.passwd.R
import dev.weazyexe.passwd.domain.Entry
import dev.weazyexe.passwd.domain.Group
import dev.weazyexe.passwd.domain.mock
import dev.weazyexe.passwd.domain.mocks
import dev.weazyexe.passwd.ui.common.core.PasswdScreenPreview
import dev.weazyexe.passwd.ui.common.core.PreviewContent
import dev.weazyexe.passwd.ui.screens.main.blocks.GroupsBlock
import dev.weazyexe.passwd.ui.screens.main.blocks.RecentEntriesBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainBody(
    recentEntries: List<Entry>,
    groups: List<Group>,
    onGroupClick: (Group) -> Unit = {},
    onAddClick: () -> Unit = {}
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onAddClick() }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.accessibility_add_label)
                )
            }
        }
    ) {
        Column(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            RecentEntriesBlock(entries = recentEntries)
            GroupsBlock(
                groups = groups,
                onGroupClick = onGroupClick
            )
        }
    }
}

@PasswdScreenPreview
@Composable
private fun MainBodyPreview() {
    PreviewContent {
        MainBody(
            recentEntries = Entry.mocks(),
            groups = listOf(Group.mock(), Group.mock(), Group.mock())
        )
    }
}