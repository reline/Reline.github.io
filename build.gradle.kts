import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "io.github.reline"
version = "1.0-SNAPSHOT"

afterEvaluate {
    extensions.findByType(ComposeExtension::class.java)?.apply {
        val composeCompilerVersion = project.property("compose.compiler.version") as String
        kotlinCompilerPlugin.set(composeCompilerVersion)
        val kotlinVersion = project.property("kotlin.version") as String
        kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=$kotlinVersion")
    }
}

kotlin {
    wasmJs {
        moduleName = "website"
        browser {
            commonWebpackConfig {
                outputFileName = "website.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    // Uncomment and configure this if you want to open a browser different from the system default
                    // open = mapOf(
                    //     "app" to mapOf(
                    //         "name" to "google chrome"
                    //     )
                    // )

                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.rootDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                api(compose.components.resources)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val wasmJsMain by getting
    }
}

compose.experimental {
    web.application {}
}
