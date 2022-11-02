buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Dependencies.hiltVersion}")
    }
}

plugins {
    id("com.android.application") version Environment.androidPluginVersion apply false
    id("com.android.library") version Environment.androidPluginVersion apply false
    id("org.jetbrains.kotlin.android") version Dependencies.kotlinVersion apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}