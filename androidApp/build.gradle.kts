plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "ru.kaer.documentsapp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "ru.kaer.documentsapp.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)

    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.material:material:1.5.3")
    implementation ("com.google.android.material:material:1.10.0")
}