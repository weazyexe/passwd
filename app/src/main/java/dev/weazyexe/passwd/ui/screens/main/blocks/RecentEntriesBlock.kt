/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.main.blocks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.weazyexe.passwd.R
import dev.weazyexe.passwd.domain.Entry
import dev.weazyexe.passwd.domain.mocks
import dev.weazyexe.passwd.ui.common.components.RecentEntry
import dev.weazyexe.passwd.ui.common.core.PasswdViewPreview
import dev.weazyexe.passwd.ui.common.core.PreviewContent
import dev.weazyexe.passwd.ui.common.theme.Typography

@Composable
fun ColumnScope.RecentEntriesBlock(
    entries: List<Entry>
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp),
        text = stringResource(id = R.string.main_recent_entries),
        style = Typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(entries) { entry ->
            RecentEntry(
                modifier = Modifier.padding(8.dp),
                entry = entry
            )
        }
    }
}

@PasswdViewPreview
@Composable
private fun RecentEntriesBlockPreview() {
    PreviewContent {
        Column {
            RecentEntriesBlock(entries = Entry.mocks())
        }
    }
}