buildscript {
    config {
        applyAndroid { isApplication ->
            androidLibs.plugins.android.run {
                if (isApplication) application
                else library
            }
        }
        apply(provider = commonLibs.plugins.kotlin.android)
        apply(provider = commonLibs.plugins.kotlin.kapt)
        apply(provider = commonLibs.plugins.kotlin.parcelize)
        apply(provider = commonLibs.plugins.detekt)
        apply(provider = androidLibs.plugins.hilt)

        dependencies {
            "implementation"(commonLibs.bundles.core)
            "implementation"(androidLibs.bundles.core)
            "kapt"(androidLibs.android.dagger.hilt.compiler)
            "implementation"(androidLibs.bundles.hilt)

            "testImplementation"(testLibs.bundles.core.unit)
            "androidTestImplementation"(testLibs.bundles.core.instrumental)
        }
    }
}
