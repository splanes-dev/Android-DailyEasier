package com.splanes.dailyease.domain.feature.auth

import kotlinx.coroutines.flow.Flow

interface UserAuthService {
    suspend fun currentUserAuth(): Flow<UserAuth?>
    suspend fun signIn(auth: UserAuth): Boolean
    suspend fun signUp(email: String, password: String): Boolean
}
