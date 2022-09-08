package com.splanes.dailyeasier.ui.presentation.feature.auth

import com.splanes.dailyease.domain.common.logger.crash

sealed interface AuthUiStateValue<AuthUiData : UserAuthUiData> {

    fun data(): AuthUiData

    object Undefined : AuthUiStateValue<Nothing> {
        override fun data(): Nothing {
            crash { "AuthUiStateValue.Undefined cannot have any UserAuthUiData associated" }
        }
    }

    @JvmInline
    value class Loading(private val loaderData: UserAuthUiData.Loading) :
        AuthUiStateValue<UserAuthUiData.Loading> {
        override fun data(): UserAuthUiData.Loading = loaderData
    }

    @JvmInline
    value class Error(
        private val errorData: UserAuthUiData.Error
    ) : AuthUiStateValue<UserAuthUiData.Error> {
        override fun data(): UserAuthUiData.Error = errorData
    }

    @JvmInline
    value class SignIn(private val signInData: SignInUiData) : AuthUiStateValue<SignInUiData> {
        override fun data(): SignInUiData = signInData
    }

    @JvmInline
    value class SignUp(private val signUpUiData: SignUpUiData) : AuthUiStateValue<SignUpUiData> {
        override fun data(): SignUpUiData = signUpUiData
    }

    companion object
}

fun AuthUiStateValue.Companion.parse(data: UserAuthUiData) = when (data) {
    is UserAuthUiData.Error -> AuthUiStateValue.Undefined
    is UserAuthUiData.Loading -> AuthUiStateValue.Undefined
    is SignInUiData -> AuthUiStateValue.SignIn(data)
    is SignUpUiData -> AuthUiStateValue.SignUp(data)
}
