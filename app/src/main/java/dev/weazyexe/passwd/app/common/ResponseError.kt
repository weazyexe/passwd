/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.app.common

import androidx.annotation.StringRes
import dev.weazyexe.passwd.R

/**
 * Exception wrapper
 */
sealed class ResponseError(@StringRes open val errorMessage: Int) : Throwable() {

    class UnknownError(
        override val errorMessage: Int = R.string.error_unknown
    ) : ResponseError(errorMessage)

    class NoInternetError(
        override val errorMessage: Int = R.string.error_no_internet
    ) : ResponseError(errorMessage)

    class TimeoutError(
        override val errorMessage: Int = R.string.error_timed_out
    ) : ResponseError(errorMessage)
}