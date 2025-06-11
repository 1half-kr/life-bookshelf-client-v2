plugins {
    id("tdd.android.feature")
    id("tdd.android.compose")
}

android {
    namespace = "com.tdd.navigation"
}

dependencies {
    implementation(projects.core)
}