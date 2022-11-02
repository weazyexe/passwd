/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.common.core

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import dev.weazyexe.passwd.ui.common.theme.PasswdTheme

@Preview(
    name = "Light theme / Mobile",
    device = Devices.PIXEL_3A,
    showBackground = true,
    showSystemUi = true
)
@Preview(
    name = "Dark theme / Mobile",
    device = Devices.PIXEL_3A,
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class PasswdScreenPreview

@Preview(
    name = "Light theme",
    showBackground = true,
)
@Preview(
    name = "Dark theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class PasswdViewPreview

@Composable
fun PreviewContent(content: @Composable () -> Unit) {
    PasswdTheme {
        Surface {
            content()
        }
    }
}