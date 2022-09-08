@file:Suppress("UnstableApiUsage")

android {
    namespace = "com.splanes.dailyeasier.domain"

    sdkConfig(SdkVersion(min = AndroidSdk.Pie, compile = AndroidSdk.Tiramisu))

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
}
