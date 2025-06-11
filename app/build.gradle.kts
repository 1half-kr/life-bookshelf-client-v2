plugins {
    id("tdd.android.application")
    id("tdd.android.hilt")
    id("tdd.android.kotlin")
    id("tdd.retrofit")
}

android {
    namespace = "com.tdd.bookshelf"

    defaultConfig {
    }
}

dependencies {
    implementation(projects.feature)
    implementation(projects.domain)
    implementation(projects.core)
    implementation(projects.data)
}