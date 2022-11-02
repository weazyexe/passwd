plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("com.diffplug.spotless") version Environment.spotlessVersion
    id("com.google.devtools.ksp") version Environment.kspVersion

    kotlin("kapt")
    kotlin("plugin.serialization") version Dependencies.kotlinVersion
}

android {
    compileSdk = Environment.compileSdk

    defaultConfig {
        applicationId = Environment.applicationId
        minSdk = Environment.minSdk
        targetSdk = Environment.targetSdk
        versionCode = Environment.versionCode
        versionName = Environment.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.composeCompilerVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

dependencies {

    implementation(fileTree("$rootDir/app/libs"))

    // androidx
    implementation("androidx.core:core-ktx:${Dependencies.coreKtxVersion}")
    implementation("androidx.core:core-splashscreen:${Dependencies.splashScreenVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Dependencies.lifecycleRuntimeKtxVersion}")
    implementation("androidx.activity:activity-compose:${Dependencies.activityComposeVersion}")
    implementation("com.google.android.material:material:${Dependencies.materialVersion}")

    // compose
    implementation(platform("androidx.compose:compose-bom:${Dependencies.composeBomVersion}"))
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-window-size-class")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // navigation
    implementation("androidx.navigation:navigation-compose:${Dependencies.navigationComposeVersion}")
    implementation("androidx.hilt:hilt-navigation-compose:${Dependencies.hiltNavComposeVersion}")
    implementation( "io.github.raamcosta.compose-destinations:core:${Dependencies.composeDestinationsVersion}")
    ksp("io.github.raamcosta.compose-destinations:ksp:${Dependencies.composeDestinationsVersion}")

    // kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependencies.coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Dependencies.coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Dependencies.coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Dependencies.kotlinxSerializationVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:${Dependencies.kotlinxDatetimeVersion}")

    // accompanist
    implementation("com.google.accompanist:accompanist-swiperefresh:${Dependencies.accompanistVersion}")
    implementation("com.google.accompanist:accompanist-permissions:${Dependencies.accompanistVersion}")

    // di
    implementation("com.google.dagger:hilt-android:${Dependencies.hiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${Dependencies.hiltVersion}")

    // testing
    testImplementation("junit:junit:${Testing.junitVersion}")
    androidTestImplementation("androidx.test.ext:junit:${Testing.junitExtVersion}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Testing.espressoCoreVersion}")
}

spotless {
    kotlin {
        target("**/*.kt")
        licenseHeaderFile(file("${project.rootDir}/spotless/LicenseHeader.txt"))
    }
}

kapt {
    correctErrorTypes = true
}