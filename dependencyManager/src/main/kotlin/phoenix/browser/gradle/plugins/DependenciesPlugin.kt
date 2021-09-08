package phoenix.browser.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project>{

    override fun apply(target: Project) {
        //Do nothing here
    }

    companion object {
        object Versions {
            const val androidXCore = "1.6.0"
            const val appCompat = "1.3.1"
            const val material = "1.4.0"
            const val compose = "1.0.1"
            const val lifecycleRuntime = "2.3.1"
            const val activityCompose = "1.3.1"

            const val jUnit = "4.13.2"
            const val androidJUnitExt = "1.1.3"
            const val espressoCore = "3.4.0"
        }

        object Libs {
            const val androidxCore = "androidx.core:core-ktx:${Versions.androidXCore}"
            const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
            const val material = "com.google.android.material:material:${Versions.material}"
            object Compose {
                const val ui = "androidx.compose.ui:ui:${Versions.compose}"
                const val material = "androidx.compose.material:material:${Versions.compose}"
                const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
                const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
                const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            }
            const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
        }

        object TestLibs {
            const val jUnit = "junit:junit:${Versions.jUnit}"
            const val androidJUnitExt = "androidx.test.ext:junit:${Versions.androidJUnitExt}"
            const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
            object Compose {
                const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
            }
        }
    }
}