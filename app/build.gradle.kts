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

    //support libs:
    implementation(DependenciesPlugin.Companion.Libs.androidxCore)
    implementation(DependenciesPlugin.Companion.Libs.appCompat)
    implementation(DependenciesPlugin.Companion.Libs.material)

    //compose:
    implementation(DependenciesPlugin.Companion.Libs.Compose.ui)
    implementation(DependenciesPlugin.Companion.Libs.Compose.material)
    implementation(DependenciesPlugin.Companion.Libs.Compose.uiToolingPreview)
    implementation(DependenciesPlugin.Companion.Libs.Compose.activity)

    //arch components
    implementation(DependenciesPlugin.Companion.Libs.lifecycle)

    //Mozilla libs:

    //Concept
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Concept.awesomeBar)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Concept.engine)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Concept.fetch)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Concept.storage)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Concept.tabsTray)

    //Browser
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.awesomeBar)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.engineSystem)
    //TODO Add engineGecko, But first file a data-review request!
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.domains)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.autoComplete)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.errorPages)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.errorPages)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.icons)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.sessionStorage)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.state)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.tabsTray)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Browser.thumbnails)

    //feature
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.intent)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.pwa)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.readerView)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.readerView)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.qrCode)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.search)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.session)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.findInPage)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Feature.sitePermissions)

    //Support
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Support.ktx)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Support.test)
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Support.utils)

    //standalone
    implementation(DependenciesPlugin.Companion.Libs.Mozilla.Standalone.publicSuffix)

    //End of Mozilla components

    //test libs:
    testImplementation(DependenciesPlugin.Companion.TestLibs.jUnit)
    androidTestImplementation(DependenciesPlugin.Companion.TestLibs.androidJUnitExt)
    androidTestImplementation(DependenciesPlugin.Companion.TestLibs.espressoCore)
    androidTestImplementation(DependenciesPlugin.Companion.TestLibs.Compose.uiTestJunit4)
    debugImplementation(DependenciesPlugin.Companion.Libs.Compose.uiTooling)
}