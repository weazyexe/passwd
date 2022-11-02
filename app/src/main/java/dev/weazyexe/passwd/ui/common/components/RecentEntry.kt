/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.weazyexe.passwd.domain.Entry
import dev.weazyexe.passwd.domain.mock
import dev.weazyexe.passwd.ui.common.core.PasswdViewPreview
import dev.weazyexe.passwd.ui.common.core.PreviewContent
import dev.weazyexe.passwd.ui.common.theme.Typography
import dev.weazyexe.passwd.utils.format

@Composable
fun RecentEntry(
    modifier: Modifier = Modifier,
    entry: Entry
) {
    ElevatedCard(
        modifier = modifier.width(192.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .semantics(mergeDescendants = true) {}
        ) {
            Icon(
                imageVector = Icons.Default.Key,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = entry.title,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = entry.group.title,
                style = Typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = entry.lastViewedAt.format(),
                style = Typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@PasswdViewPreview
@Composable
private fun RecentEntryPreview() {
    PreviewContent {
        RecentEntry(entry = Entry.mock())
    }
}