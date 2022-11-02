/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.common.core

import dev.weazyexe.passwd.app.common.ResponseError


/**
 * Loading state for data
 *
 * @property data loaded data
 * @property error error what was thrown during the loading
 * @property isLoading loading state
 * @property isSwipeRefresh is loading was launched from swipe refresh
 * @property isTransparent is loading transparent
 */
class LoadState<T> private constructor(
    val data: T? = null,
    val error: ResponseError? = null,
    val isLoading: Boolean = false,
    val isSwipeRefresh: Boolean = false,
    val isTransparent: Boolean = false
) {

    companion object {

        /**
         * Create empty [LoadState]
         */
        fun <T> empty() = LoadState<T>()

        /**
         * Create loading [LoadState]
         */
        fun <T> loading(
            isSwipeRefresh: Boolean = false,
            isTransparent: Boolean = false,
            oldData: T? = null
        ): LoadState<T> =
            LoadState(
                data = oldData,
                error = null,
                isLoading = true,
                isSwipeRefresh = isSwipeRefresh,
                isTransparent = isTransparent
            )

        /**
         * Create error [LoadState]
         */
        fun <T> error(
            e: ResponseError,
            oldData: T? = null
        ): LoadState<T> =
            LoadState(
                data = oldData,
                error = e,
                isLoading = false,
                isSwipeRefresh = false
            )

        /**
         * Create successful [LoadState] with data
         */
        fun <T> data(data: T): LoadState<T> =
            LoadState(
                data = data,
                error = null,
                isLoading = false,
                isSwipeRefresh = false
            )

        /**
         * Create successful [LoadState] with [Unit]
         */
        fun data(): LoadState<Unit> =
            LoadState(
                data = Unit,
                error = null,
                isLoading = false,
                isSwipeRefresh = false
            )
    }
}