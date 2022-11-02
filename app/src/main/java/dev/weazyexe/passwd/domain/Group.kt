/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.domain

data class Group(
    val id: String,
    val title: String
) {

    companion object
}

fun Group.Companion.mock(): Group = Group(
    id = "",
    title = "Services"
)

fun Group.Companion.mocks() = listOf(Group.mock(), Group.mock(), Group.mock())
