/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.main.blocks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.weazyexe.passwd.R
import dev.weazyexe.passwd.domain.Group
import dev.weazyexe.passwd.domain.mocks
import dev.weazyexe.passwd.ui.common.core.PasswdViewPreview
import dev.weazyexe.passwd.ui.common.core.PreviewContent
import dev.weazyexe.passwd.ui.common.theme.Typography

@Composable
fun ColumnScope.GroupsBlock(
    groups: List<Group>,
    onGroupClick: (Group) -> Unit = {}
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 24.dp, bottom = 8.dp),
        text = stringResource(id = R.string.main_groups),
        style = Typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    LazyColumn {
        items(groups) {
            GroupItem(
                group = it,
                onClick = onGroupClick
            )
        }
    }
}

@Composable
private fun GroupItem(
    group: Group,
    onClick: (Group) -> Unit
) {
    Text(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth()
            .clickable { onClick(group) },
        text = group.title,
        style = Typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@PasswdViewPreview
@Composable
private fun GroupsBlockPreview() {
    PreviewContent {
        Column {
            GroupsBlock(groups = Group.mocks())
        }
    }
}