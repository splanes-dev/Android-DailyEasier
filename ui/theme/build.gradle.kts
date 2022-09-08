@file:Suppress("UnstableApiUsage")

android {
    namespace = "com.splanes.dailyeasier.ui.theme"

    sdkConfig(SdkVersion(min = AndroidSdk.Pie, compile = AndroidSdk.Tiramisu))

    enableCompose(androidLibs.versions.android.compose.compiler.orNull)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        useJava11()
        requireOptIn()
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    api(androidLibs.bundles.compose)
    androidTestApi(testLibs.compose.instrumental)
}
