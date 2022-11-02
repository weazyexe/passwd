/**
 * Copyright © 2022 Timur Zadvornov. All rights reserved.
 */
package dev.weazyexe.passwd.ui.screens.main

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.weazyexe.passwd.ui.common.core.CoreViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : CoreViewModel<MainState, MainEffect>() {

    override val initialState: MainState = MainState()
}