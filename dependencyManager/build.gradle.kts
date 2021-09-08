plugins {
    kotlin("jvm") version "1.5.21"
    id("java-gradle-plugin")
}
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

sourceSets {
    main {
        java {
            srcDir("src/main/kotlin")
        }
    }
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
}

gradlePlugin {
    plugins {
        create("dependenciesPlugins") {
            id = "phoenix.browser.gradle.phoenix.browser.gradle.plugins.dependencies"
            implementationClass = "phoenix.browser.gradle.plugins.DependenciesPlugin"
        }
    }
}