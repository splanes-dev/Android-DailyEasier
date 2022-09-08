package com.splanes.dailyease.domain.feature.auth

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserAuth(
    val email: String,
    val credentials: String,
    val roles: List<UserRole> = listOf(UserRole.Basic)
) : Parcelable {

    @IgnoredOnParcel
    val role get() = roles.max()
}
