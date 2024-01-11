import org.gradle.api.publish.maven.MavenPublication

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
//    id("android-maven")
//    id("kotlin-android")
//    id("kotlin-android-extensions")
    id("maven-publish")
}

android {
    namespace = "com.app24.callsdk"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
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
    }
}

//publishing {
//    publications {
//        create<MavenPublication>("bar") {
//            groupId = "com.app24"
//            artifactId = "callsdk"
//            version = "0.1-alpha"
//            artifact("$buildDir/outputs/aar/CallLibrary-release.aar")
//        }
//    }
//}

publishing {
    publications {
        create<MavenPublication>("maven") {
                groupId = "com.github.nwudoebuka"
                artifactId = "callsdk"
                version = "0.1-alpha"
                pom {
                    description = "First release"
                }
        }
    }
    repositories {
        mavenLocal()
    }
}

//afterEvaluate {
//    publishing {
//        publications {
//            create<MavenPublication>("release") {
//                from(components["release"])
//
//                groupId = "com.github.nwudoebuka"
//                artifactId = "callsdk"
//                version = "0.1-alpha"
//                pom {
//                    description = "First release"
//                }
////                artifact("$buildDir/outputs/aar/CallLibrary-release.aar")
//            }
//        }
//    }
//}
repositories {
    google()
    mavenCentral()
    mavenLocal()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)        // << --- ADD This
    }
}
//===============================

java {
    sourceCompatibility = JavaVersion.VERSION_17            // << --- ADD This
    targetCompatibility = JavaVersion.VERSION_17
}


dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}