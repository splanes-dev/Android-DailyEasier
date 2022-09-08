import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.ProductFlavor
import com.android.build.api.dsl.VariantDimension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

enum class AndroidSdk(val version: Int, val level: Int, val code: String) {
    Oreo(version = 8, level = 26, code = "O"),
    Oreo_MR1(version = 8, level = 27, code = "O_MR1"),
    Pie(version = 9, level = 28, code = "P"),
    QuinceTart(version = 10, level = 29, code = "Q"),
    RedVelvetCake(version = 11, level = 30, code = "R"),
    SnowCone(version = 12, level = 31, code = "S"),
    SnowCone_v2(version = 12, level = 32, code = "S_V2"),
    Tiramisu(version = 13, level = 33, code = "TIRAMISU"),
}

data class SdkVersion(val min: AndroidSdk, val compile: AndroidSdk)

fun <BF : BuildFeatures, BT : BuildType, DF : DefaultConfig, PF : ProductFlavor> CommonExtension<BF, BT, DF, PF>.enableCompose(
    ktCompilerVersion: String?
) {
    buildFeatures { compose = true }
    ktCompilerVersion?.let { version -> composeOptions { kotlinCompilerExtensionVersion = version } }
}

fun KotlinJvmOptions.useJava11() {
    withJava(JavaVersion.VERSION_11)
}

fun KotlinJvmOptions.requireOptIn() {
    withCompilerArgs("opt-in" to "kotlin.RequiresOptIn")
}

fun KotlinJvmOptions.withJava(version: JavaVersion) {
    jvmTarget = version.toString()
}

fun KotlinJvmOptions.withCompilerArgs(vararg args: Pair<String, String>) {
    freeCompilerArgs = args.toList().map { (arg, value) -> "-$arg=$value" }
}

fun BaseExtension.sdkConfig(version: SdkVersion) {
    compileSdkVersion(version.compile.level)
    defaultConfig {
        minSdk = version.min.level
        compileSdkVersion(version.compile.level)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
        consumerProguardFiles("consumer-rules.pro")
    }
}
