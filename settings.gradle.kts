// Remove `@file:Suppress("UnstableApiUsage")` once Version Catalogs has had released as @Stable
@file:Suppress("UnstableApiUsage")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

apply(from = "gradle/dependency-catalogs.settings.gradle.kts")

rootProject.name = "DailyEasier"
include(":app")
include(":data")
include(":domain")
include(":ui:theme")
include(":ui:components")
include(":ui:presentation")
