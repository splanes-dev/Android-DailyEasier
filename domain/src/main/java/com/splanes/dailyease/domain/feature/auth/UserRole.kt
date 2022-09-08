package com.splanes.dailyease.domain.feature.auth

enum class UserRole(val access: Int) {
    Basic(access = 1),
    Tester(access = 2),
    Admin(access = Int.MAX_VALUE),
}

inline val UserRole.isBasic get() = this == UserRole.Basic
inline val UserRole.isTester get() = this == UserRole.Tester
inline val UserRole.isAdmin get() = this == UserRole.Admin
infix fun UserRole.compareWith(other: UserRole) = access - other.access
infix fun UserRole.gt(other: UserRole) = this compareWith other > 0
infix fun UserRole.eq(other: UserRole) = this compareWith other == 0
infix fun UserRole.lt(other: UserRole) = this compareWith other < 0
fun List<UserRole>.max() = maxBy { r -> r.access }
