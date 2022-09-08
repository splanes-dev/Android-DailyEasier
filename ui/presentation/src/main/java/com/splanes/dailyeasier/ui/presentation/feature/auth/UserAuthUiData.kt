package com.splanes.dailyeasier.ui.presentation.feature.auth

import androidx.annotation.StringRes
import com.splanes.dailyease.domain.common.strings.Empty
import com.splanes.dailyease.domain.common.uuid.Uuid
import com.splanes.dailyease.domain.feature.auth.UserAuth
import com.splanes.dailyeasier.ui.presentation.common.uidata.ErrorHandleBehavior
import com.splanes.dailyeasier.ui.presentation.common.uidata.ErrorUiData
import com.splanes.dailyeasier.ui.presentation.common.uidata.LoadableUiData
import java.util.UUID

sealed class UserAuthUiData(
    open val email: String,
    open val credentials: String
) {
    data class Loading(
        override val uuid: UUID = Uuid.next(),
        @StringRes override val message: Int? = null
    ) : UserAuthUiData(email = String.Empty, credentials = String.Empty), LoadableUiData

    data class Error(
        override val uuid: UUID = Uuid.next(),
        override val cause: Throwable? = null,
        override val message: Int? = null,
        override val behavior: ErrorHandleBehavior
    ) : UserAuthUiData(email = String.Empty, credentials = String.Empty), ErrorUiData

    companion object {
        val InitialStateLoaderUuid
    }
}

data class SignUpUiData(
    val name: String,
    override val email: String,
    override val credentials: String
) : UserAuthUiData(name, credentials) {
    companion object {
        val empty get() = SignUpUiData(name = "", email = "", credentials = "")
    }
}

data class SignInUiData(
    override val email: String,
    override val credentials: String
) : UserAuthUiData(email, credentials)

inline val UserAuthUiData.Companion.Initial
    get() = UserAuthUiData.Loading(
        uuid
        message = null,
    )

fun UserAuth.isNotEmpty() = email.isNotEmpty() && credentials.isNotEmpty()

fun SignUpUiData?.toSignIn() = SignInUiData(
    email = this?.email.orEmpty(),
    credentials = this?.credentials.orEmpty()
)

fun SignInUiData?.toSignUp() = SignUpUiData(
    name = String.Empty,
    email = this?.email.orEmpty(),
    credentials = this?.credentials.orEmpty()
)
