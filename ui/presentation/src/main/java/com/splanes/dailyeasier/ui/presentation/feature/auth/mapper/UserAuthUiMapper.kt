package com.splanes.dailyeasier.ui.presentation.feature.auth.mapper

import com.splanes.dailyease.domain.feature.auth.UserAuth
import com.splanes.dailyeasier.ui.presentation.feature.auth.SignInUiData
import com.splanes.dailyeasier.ui.presentation.feature.auth.SignUpUiData
import com.splanes.dailyeasier.ui.presentation.feature.auth.UserAuthUiData
import com.splanes.dailyeasier.ui.presentation.feature.auth.isNotEmpty
import javax.inject.Inject

class UserAuthUiMapper @Inject constructor() {

    fun map(auth: UserAuth?): UserAuthUiData = when {
        auth == null -> SignUpUiData.empty
        auth.isNotEmpty() -> SignInUiData(
            email = auth.email,
            credentials = auth.credentials
        )
        else -> SignUpUiData.empty
    }
}
