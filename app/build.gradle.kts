plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.movieapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.movieapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":feature:movie:ui"))
    implementation(project(":core:common"))
    implementation(project(":core:feature_api"))

    implementation(Deps.core)
    implementation(CoroutinesLifecycleScope.lifeCycleRuntime)
    implementation(JetpackCompose.composeActivity)
    implementation(JetpackCompose.composeUi)
    implementation(JetpackCompose.composeUiToolingPreview)
    implementation(JetpackCompose.composeMaterial3)
    implementation(JetpackCompose.composeMaterial)

    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)

    androidTestImplementation(ComposeAndroidTestImplementation.composeUiTest)
    debugImplementation(ComposeDebugImplementation.toolingUi)
    debugImplementation(ComposeDebugImplementation.manifestTest)


    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltCompiler)

    implementation(JetpackCompose.navigation)
}