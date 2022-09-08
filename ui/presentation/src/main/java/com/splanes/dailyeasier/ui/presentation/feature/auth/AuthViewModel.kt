package com.splanes.dailyeasier.ui.presentation.feature.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.splanes.dailyease.domain.common.logger.crash
import com.splanes.dailyease.domain.feature.auth.UserAuthService
import com.splanes.dailyeasier.ui.presentation.common.viewmodel.ComponentViewModel
import com.splanes.dailyeasier.ui.presentation.common.viewmodel.launchOnIO
import com.splanes.dailyeasier.ui.presentation.feature.auth.mapper.UserAuthUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.withContext

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authService: UserAuthService,
    private val userAuthMapper: UserAuthUiMapper
) : ComponentViewModel() {

    private val _data: MutableStateFlow<UserAuthUiData> = MutableStateFlow(UserAuthUiData.Loading())
    val data: State<UserAuthUiData>
        @Composable
        get() = _data.collectAsState(initial = UserAuthUiData.Loading())

    val uiStateValue: State<AuthUiStateValue<*>>
        @Composable
        get() = uiStateValueChannel
            .receiveAsFlow()
            .collectAsState(initial = AuthUiStateValue.Undefined)

    private val uiStateValueChannel: Channel<AuthUiStateValue<*>> = Channel()

    init {
        tryGetLocalUserAuth()
    }

    private fun tryGetLocalUserAuth() {
        launchOnIO {
            authService
                .currentUserAuth()
                .map(userAuthMapper::map)
                .distinctUntilChanged()
                .onEach { uiData ->
                    withContext(coroutineContext) {
                        uiStateValueChannel.send(AuthUiStateValue.parse(uiData))
                    }
                }.handle { auth -> _data.value = auth }
        }
    }

    fun onSwitchAuthValue() {
        when (val value = _data.value) {
            is UserAuthUiData.Loading,
            is UserAuthUiData.Error
            -> crash {
                "This branch should not be possible... Button must be disable while loading / error is shown."
            }
            is SignInUiData -> _data.value = value.toSignUp()
            is SignUpUiData -> _data.value = value.toSignIn()
        }
    }
}
