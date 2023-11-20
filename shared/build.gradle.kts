plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("app.cash.sqldelight")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.sqlDelightRuntime)
                implementation(libs.sqlDelightCoroutinesExtensions)
                implementation(libs.coroutines)
                implementation(libs.kotlinDateTime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.sqlDelightRuntime)
                implementation(libs.sqlDelightCoroutinesExtensions)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.sqlDelightAndroidDriver)
                implementation(libs.sqlDelightCoroutinesExtensions)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.sqlDelightNativeDriver)
                implementation(libs.sqlDelightCoroutinesExtensions)
            }
        }

    }
}

android {
    namespace = "com.fencak.myplants"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}
sqldelight {
    databases{
        create("PlantsDatabase") {
            packageName.set("com.fencak.myplants.database")
        }
    }
}