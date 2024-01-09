import org.gradle.api.publish.maven.MavenPublication

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.app24.calllibrary"
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
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.github.nwudoebuka"
                artifactId = "CallLibrary"
                version = "0.1-alpha"
                artifact("$buildDir/outputs/aar/CallLibrary-release.aar")
            }
        }
    }
}
//repositories {
//    google()
//    mavenCentral()
//    maven("GithubPackages") {
//        url = uri("https://maven.pkg.github.com/nwudoebuka/callsdk")
//        credentials {
//            username = "nwudoebuka" // replace with environment variables System.getenv(GITHUB_USERNAME)
//            password = "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" // replace with environment variables System.getenv(GITHUB_PASSWORD)
//        }
//    }
//}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}