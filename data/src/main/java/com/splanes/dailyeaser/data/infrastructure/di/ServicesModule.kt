package com.splanes.dailyeaser.data.infrastructure.di

import com.splanes.dailyease.domain.feature.auth.UserAuthService
import com.splanes.dailyeaser.data.feature.auth.service.UserAuthServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ServicesModule {

	@Binds
	abstract fun authService(impl: UserAuthServiceImpl): UserAuthService
}
