package com.splanes.dailyeaser.data.feature.auth.service

import com.splanes.dailyease.domain.feature.auth.UserAuth
import com.splanes.dailyease.domain.feature.auth.UserAuthService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserAuthServiceImpl @Inject constructor() : UserAuthService {

    override suspend fun currentUserAuth(): Flow<UserAuth?> {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(auth: UserAuth): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(email: String, password: String): Boolean {
        TODO("Not yet implemented")
    }
}
