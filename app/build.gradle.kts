import phoenix.browser.gradle.plugins.DependenciesPlugin

plugins {
    id("com.android.application")
    kotlin("android")
    id("phoenix.browser.gradle.phoenix.browser.gradle.plugins.dependencies")
}

val composeVersion = "1.0.1"

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "phoenix.browser"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(DependenciesPlugin.Companion.Libs.androidxCore)
    implementation(DependenciesPlugin.Companion.Libs.appCompat)
    implementation(DependenciesPlugin.Companion.Libs.material)
    implementation(DependenciesPlugin.Companion.Libs.Compose.ui)
    implementation(DependenciesPlugin.Companion.Libs.Compose.material)
    implementation(DependenciesPlugin.Companion.Libs.Compose.uiToolingPreview)
    implementation(DependenciesPlugin.Companion.Libs.lifecycle)
    implementation(DependenciesPlugin.Companion.Libs.Compose.activity)
    testImplementation(DependenciesPlugin.Companion.TestLibs.jUnit)
    androidTestImplementation(DependenciesPlugin.Companion.TestLibs.androidJUnitExt)
    androidTestImplementation(DependenciesPlugin.Companion.TestLibs.espressoCore)
    androidTestImplementation(DependenciesPlugin.Companion.TestLibs.Compose.uiTestJunit4)
    debugImplementation(DependenciesPlugin.Companion.Libs.Compose.uiTooling)
}