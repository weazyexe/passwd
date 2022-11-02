/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.domain

import kotlinx.datetime.LocalDateTime

data class Entry(
    val id: String,
    val title: String,
    val password: String,
    val group: Group,
    val createdAt: LocalDateTime,
    val lastViewedAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
    val url: String,
    val notes: String
) {

    companion object
}

fun Entry.Companion.mock() = Entry(
    id = "",
    title = "GitHub",
    password = "••••••••••",
    group = Group.mock(),
    createdAt = LocalDateTime(year = 2022, monthNumber = 11, dayOfMonth = 2, hour = 12, minute = 28),
    lastViewedAt = LocalDateTime(year = 2022, monthNumber = 11, dayOfMonth = 2, hour = 12, minute = 28),
    modifiedAt = LocalDateTime(year = 2022, monthNumber = 11, dayOfMonth = 2, hour = 12, minute = 28),
    url = "https://github.com",
    notes = "Some awesome notes"
)

fun Entry.Companion.mocks() = listOf(Entry.mock(), Entry.mock(), Entry.mock())