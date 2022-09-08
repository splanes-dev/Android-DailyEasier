plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    val commonCatalog = versionCatalogs.named("commonLibs")
    val androidCatalog = versionCatalogs.named("androidLibs")

    implementation(commonCatalog.findLibrary("kotlin-gradle").get())
    implementation(commonCatalog.findLibrary("detekt-gradle").get())
    implementation(commonCatalog.findLibrary("google_services-gradle").get())
    implementation(androidCatalog.findLibrary("android-gradle").get())
    implementation(androidCatalog.findLibrary("android-dagger-hilt-gradle").get())
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
        kotlinOptions.freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
    }
}
