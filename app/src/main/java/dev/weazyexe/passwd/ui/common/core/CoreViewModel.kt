/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.common.core

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Base [ViewModel] for all the screens in the app
 */
abstract class CoreViewModel<S : State, E : Effect>(
    application: Application
) : AndroidViewModel(application) {

    /**
     * UI state
     */
    private val _uiState by lazy { MutableStateFlow(initialState) }
    val uiState: StateFlow<S>
        get() = _uiState.asStateFlow()
    protected val state: S
        get() = uiState.value

    /**
     * Gets application context
     */
    protected val context: Context
        get() = getApplication<Application>().applicationContext

    /**
     * Side effects to screen channel
     */
    private val _effects = Channel<E>(Channel.BUFFERED)
    val effects: Flow<E>
        get() = _effects.receiveAsFlow()

    /**
     * Initial screen state
     */
    protected abstract val initialState: S

    /**
     * Updates the screen state
     */
    protected fun setState(stateBuilder: S.() -> S) {
        _uiState.value = stateBuilder(uiState.value)
    }

    /**
     * Triggers side-effect
     */
    protected fun E.emit() = viewModelScope.launch {
        _effects.send(this@emit)
    }
}