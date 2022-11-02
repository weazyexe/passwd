/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.utils

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun LocalDateTime.format(): String {
    val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM)
    return formatter.format(toJavaLocalDateTime())
}