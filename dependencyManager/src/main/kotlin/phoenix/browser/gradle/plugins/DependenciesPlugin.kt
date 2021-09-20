package phoenix.browser.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        /*
         add the mozilla maven to the project:
         I just want to do this here for the sake of learning how to work with gradle plugin!
         https://github.com/mozilla-mobile/android-components#maven-repository
         Seems that this is not working and giving me exception!
         */
//        target.repositories.maven {
//            it.url = target.uri("")
//        }
    }

    //Just want the warning to be gone!
    @Suppress("unused")
    companion object {
        object Versions {
            const val androidXCore = "1.6.0"
            const val appCompat = "1.3.1"
            const val material = "1.4.0"
            const val compose = "1.0.1"
            const val lifecycleRuntime = "2.3.1"
            const val lifecycle = "2.2.0"
            const val activityCompose = "1.3.1"
            const val viewModelCompose = "1.0.0-alpha07"
            const val hilt = "2.38.1"
            const val jUnit = "4.13.2"
            const val androidJUnitExt = "1.1.3"
            const val espressoCore = "3.4.0"
            const val coil = "1.3.2"
            //Mozilla versions:
            /*
            There is just one release for all of the packages
             */
            const val androidComponents = "93.0.3"
            const val leakCanary = "2.7"
            const val navigation = "2.4.0-alpha06"
            const val hiltNavigationCompose = "1.0.0-alpha03"
            const val lottie = "4.1.0"
            const val mockk = "1.12.0"
        }

        object Libs {
            const val androidxCore = "androidx.core:core-ktx:${Versions.androidXCore}"
            const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
            const val material = "com.google.android.material:material:${Versions.material}"
            const val guava = "com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava"
            object Compose {
                const val ui = "androidx.compose.ui:ui:${Versions.compose}"
                const val material = "androidx.compose.material:material:${Versions.compose}"
                const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
                const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
                const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
                const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
                const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModelCompose}"
                const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
            }

            object Lifecycle {
                const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
                const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
            }

            //I will use hilt for dependency injection
            object Hilt {
                //don't forget to set correctErrorTypes to true
                const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
                const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
                const val navigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
            }

            const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

            const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

            const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"


            /**
             * collection of android libraries made by Mozilla to build browser like applications!
             * Here are the components that I need to use in this app, Objects are categorized based the official docs!
             * Im using the browser sample to add the dependencies
             *
             * P.S: The list will be updated if I need more!
             *
             * @see <a href="https://github.com/mozilla-mobile/android-components"> Android components</a>
             * @see <a href="https://github.com/mozilla-mobile/android-components/tree/main/samples/browser">Browser sample</a>
             * @author Moein
             */
            object Mozilla {
                /**
                 * High-level components for building browser(-like) apps.
                 * @see <a href="https://github.com/mozilla-mobile/android-components#browser"> Browser component</a>
                 */
                object Browser {
                    //I never worked with this but I think I should go modular to create some wrappers around these libs to work with jetpack compose!

                    /**
                     * A customizable Awesome Bar implementation for browsers.
                     * @see <a href="https://support.mozilla.org/en-US/kb/address-bar-autocomplete-firefox?redirectslug=awesome-bar-search-firefox-bookmarks-history-tabs&redirectlocale=en-US">Awesome bar</a>
                     */
                    const val awesomeBar = "org.mozilla.components:browser-awesomebar:${Versions.androidComponents}"

                    /**
                     * This component provides APIs for managing localized and customizable domain lists
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/domains/README.md">Domains</a>
                     */
                    const val domains = "org.mozilla.components:browser-domains:${Versions.androidComponents}"

                    /**
                     * A set of components to provide autocomplete functionality.
                     * Not sure about how this going to help me in this project!
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/ui/autocomplete/README.md">Auto complete</a>
                     */
                    const val autoComplete = "org.mozilla.components:ui-autocomplete:${Versions.androidComponents}"

                    /*
                    Okay for engine part, I can use one of these two,
                    engine gecko requires data review by the mozilla team! see the process here:
                    https://wiki.mozilla.org/Data_Collection

                    As the engine system doesn't require anything but I'm not sure about the performance compare to gecko!

                    They are both using engine concept: https://github.com/mozilla-mobile/android-components/blob/main/components/concept/engine/README.md

                    Need help on this ASAP!
                     */
                    /**
                     * This is the most important component at it requires data-review(not sure what that is!).
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/engine-gecko/README.md">engine gecko</a>
                     */
                    const val engineGecko = "org.mozilla.components:browser-engine-gecko:${Versions.androidComponents}"

                    /**
                     * Engine implementation based on the system's WebView.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/engine-system/README.md"> Engine system</a>
                     */
                    const val engineSystem = "org.mozilla.components:browser-engine-system:${Versions.androidComponents}"


                    /**
                     * Responsive browser error pages for Android apps.
                     * I'm not sure about implementing this! I Should create a composable function to use this
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/errorpages/README.md">Error pages</a>
                     */
                    const val errorPages = "org.mozilla.components:browser-errorpages:${Versions.androidComponents}"

                    /**
                     * A component for loading and storing website icons (like Favicons).
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/icons/README.md">Icons</a>
                     * @see <a href="https://en.wikipedia.org/wiki/Favicon">Favicons</a>
                     */
                    const val icons = "org.mozilla.components:browser-icons:${Versions.androidComponents}"

                    /*
                    Menu dependency:
                    https://github.com/mozilla-mobile/android-components/blob/main/components/browser/menu/README.md
                    I'm not sure about this, so I won't implement this into the project
                     */

                    /**
                     * This component offers mechanisms for saving and restoring a browsing session.
                     * I don't know how this going to be helping me, It doesn't have any documentation!
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/session-storage/README.md">Session storage</a>
                     */
                    const val sessionStorage = "org.mozilla.components:browser-session-storage:${Versions.androidComponents}"

                    /**
                     * The browser-state component is responsible for maintaining the centralized state of a browser engine.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/state/README.md">State</a>
                     */
                    const val state = "org.mozilla.components:browser-state:${Versions.androidComponents}"

                    /*
                    Memory storage
                    An in-memory implementation of concept-storage. Data is not persisted to disk, and does not survive a restart. Not suitable for syncing.
                    https://github.com/mozilla-mobile/android-components/blob/main/components/browser/storage-memory/README.md

                    They didn't include this in the sample!
                     */

                    /*
                    Sync Storage
                    A syncable implementation of concept-storage backed by application-services' Places lib.

                    I'm not sure about using this! this also needs data review from firefox review!

                    More info:
                    https://github.com/mozilla-mobile/android-components/blob/main/components/browser/storage-sync/README.md

                    This library will work with firefox application's services.
                    https://mozilla.github.io/application-services/book/index.html
                     */

                    /**
                     * A customizable tabs tray for browsers.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/tabstray/README.md">TabsTray</a>
                     */
                    const val tabsTray = "org.mozilla.components:browser-tabstray:${Versions.androidComponents}"

                    /**
                     * A component for loading and storing website thumbnails (screenshot of the website).
                     * This also requires an wrapper to work with jetpack compose
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/browser/thumbnails/README.md">Thumbnails</a>
                     */
                    const val thumbnails = "org.mozilla.components:browser-thumbnails:${Versions.androidComponents}"

                    /*
                    Toolbar
                    A customizable toolbar for browsers.

                    I should make this on my own
                    https://github.com/mozilla-mobile/android-components/blob/main/components/browser/toolbar/README.md
                     */
                }

                /**
                 *  API contracts and abstraction layers for browser components.
                 *
                 * @see <a href="https://github.com/mozilla-mobile/android-components#concept">Concept</a>
                 */
                object Concept {
                    /*
                    This also implemented in the sample project.
                     */

                    /**
                     * An abstract definition of an awesome bar component.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/concept/awesomebar/README.md">awesome bar</a>
                     */
                    const val awesomeBar = "org.mozilla.components:concept-awesomebar:${Versions.androidComponents}"

                    /**
                     * The concept-engine component contains interfaces and abstract classes that hide the actual browser engine implementation from other components needing access to the browser engine.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/concept/engine/README.md">Engine</a>
                     */
                    const val engine = "org.mozilla.components:concept-engine:${Versions.androidComponents}"

                    /**
                     * The concept-fetch component contains interfaces for defining an abstract HTTP client for fetching resources.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/concept/fetch/README.md">Fetch</a>
                     */
                    const val fetch = "org.mozilla.components:concept-fetch:${Versions.androidComponents}"

                    /**
                     * An abstract definition of a push service component.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/concept/push/README.md">Push</a>
                     */
                    //const val push = "org.mozilla.components:concept-push:${Versions.androidComponents}"

                    /**
                     * The concept-storage component contains interfaces and abstract classes that describe a "core data" storage layer.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/concept/storage/README.md">storage</a>
                     */
                    const val storage = "org.mozilla.components:concept-storage:${Versions.androidComponents}"

                    /**
                     * Abstract definition of a tabs tray component.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/concept/tabstray/README.md">tabs tray</a>
                     */
                    const val tabsTray = "org.mozilla.components:concept-tabstray:${Versions.androidComponents}"

                    /*
                    I didn't implement this in the browser section

                    https://github.com/mozilla-mobile/android-components/blob/main/components/concept/toolbar/README.md
                     */
                }

                /**
                 * Combined components to implement feature-specific use cases.
                 *
                 * @see <a href="https://github.com/mozilla-mobile/android-components#feature">Feature</a>
                 */
                object Feature {

                    /**
                     * Feature implementation for apps that want to use Android downloads manager.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/downloads/README.md">downloads</a>
                     * @see <a href="https://developer.android.com/reference/android/app/DownloadManager">android download manager</a>
                     */
                    const val downloads = "org.mozilla.components:feature-downloads:${Versions.androidComponents}"
                    /*
                    I would use my own implementation of download manager, I need more customization and control!
                     */

                    /**
                     * A component that provides intent processing functionality by combining various other feature modules.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/intent/README.md">Intent</a>
                     */
                    const val intent = "org.mozilla.components:feature-intent:${Versions.androidComponents}"

                    /**
                     * Feature implementation for Progressive Web Apps (PWA).
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/pwa/README.md">PWA</a>
                     */
                    const val pwa = "org.mozilla.components:feature-pwa:${Versions.androidComponents}"

                    /**
                     * A component wrapping/providing a Reader View WebExtension.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/readerview/README.md">reader view</a>
                     */
                    const val readerView = "org.mozilla.components:feature-readerview:${Versions.androidComponents}"

                    /**
                     * A component that provides functionality for scanning QR codes.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/qr/README.md">QR</a>
                     */
                    const val qrCode = "org.mozilla.components:feature-qr:${Versions.androidComponents}"

                    /**
                     * A component that connects an (concept) engine implementation with the browser search module.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/search/README.md">search</a>
                     */
                    const val search = "org.mozilla.components:feature-search:${Versions.androidComponents}"

                    /**
                     * A component that connects an (concept) engine implementation with the browser session module.
                     * A HistoryTrackingDelegate implementation is also provided, which allows tying together an engine implementation with a storage module.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/session/README.md">Session</a>
                     */
                    const val session = "org.mozilla.components:feature-session:${Versions.androidComponents}"

                    /**
                     * A feature that provides Find in Page functionality.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/findinpage/README.md">Find in page</a>
                     * @see <a href="https://support.mozilla.org/en-US/kb/search-contents-current-page-text-or-links">Find in page doc</a>
                     */
                    const val findInPage = "org.mozilla.components:feature-findinpage:${Versions.androidComponents}"

                    /**
                     * A feature for showing site permission request prompts.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/feature/sitepermissions/README.md">site permissions</a>
                     */
                    const val sitePermissions = "org.mozilla.components:feature-sitepermissions:${Versions.androidComponents}"

                    /*
                    I'm not sure about this:
                    https://github.com/mozilla-mobile/android-components/blob/main/components/service/location/README.md
                     */
                }

                /**
                 * Supporting components with generic helper code.
                 *
                 * @see <a href="https://github.com/mozilla-mobile/android-components#feature">Support</a>
                 */
                object Support {
                    /*
                    Android Test
                    A collection of helpers for testing components in instrumented (on device) tests (src/androidTest)
                    https://github.com/mozilla-mobile/android-components/blob/main/components/support/android-test/README.md
                     */

                    /*
                    Base or core component containing building blocks and interfaces for other components.
                    Usually this component never needs to be added to application projects manually.
                    Other components may have a transitive dependency on some of the classes and interfaces in this component.
                     */

                    /**
                     * A set of Kotlin extensions on top of the Android framework and Kotlin standard library.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/support/ktx/README.md">KTX</a>
                     */
                    const val ktx = "org.mozilla.components:support-ktx:${Versions.androidComponents}"

                    /**
                     * A collection of helpers for testing components in local unit tests (src/test).
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/support/test/README.md">Test</a>
                     */
                    const val test = "org.mozilla.components:support-test:${Versions.androidComponents}"

                    /**
                     * Generic utility classes to be shared between projects.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/support/utils/README.md">Utils</a>
                     */
                    const val utils = "org.mozilla.components:support-utils:${Versions.androidComponents}"
                }

                /**
                 * @see <a href="https://github.com/mozilla-mobile/android-components#standalone-libraries">Standalone</a>
                 */
                object Standalone {
                    /*
                    https://github.com/mozilla-mobile/android-components/blob/main/components/lib/crash/README.md
                     */

                    /**
                     * A library for reading and using the Public Suffix List.
                     *
                     * @see <a href="https://github.com/mozilla-mobile/android-components/blob/main/components/lib/publicsuffixlist/README.md">Mozilla public suffix list</a>
                     * @see <a href="https://publicsuffix.org/">Public suffix</a>
                     */
                    const val publicSuffix = "org.mozilla.components:lib-publicsuffixlist:${Versions.androidComponents}"
                }
            }
        }

        object TestLibs {
            const val jUnit = "junit:junit:${Versions.jUnit}"
            const val androidJUnitExt = "androidx.test.ext:junit:${Versions.androidJUnitExt}"
            const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
            object Compose {
                const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
            }
            object Hilt {
                const val androidTesting = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
                const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
            }
            const val mockk = "io.mockk:mockk:${Versions.mockk}"
        }
    }
}