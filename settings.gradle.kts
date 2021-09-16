dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://maven.mozilla.org/maven2")
        }
    }
}
rootProject.name = "Phoenix"
include(":app")
includeBuild("dependencyManager")
