package dev.weazyexe.passwd.ui.screens.auth

import dagger.hilt.android.lifecycle.HiltViewModel
import dev.weazyexe.passwd.ui.common.core.CoreViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : CoreViewModel<AuthState, AuthEffect>() {

    override val initialState: AuthState = AuthState()

}