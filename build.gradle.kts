// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.library) apply false
}

// build.gradle
tasks.register("coreTest") {
    dependsOn("core:testDebugUnitTest")
}

tasks.register("featureATest") {
    dependsOn("feature:a:feature1:testDebugUnitTest", "feature:a:feature1:testDebugUnitTest")
    // 그 외 모듈들..
}

tasks.register("featureBTest") {
    dependsOn("feature:b:feature3:testDebugUnitTest", "feature:b:feature4:testDebugUnitTest")
    // 그 외 모듈들..
}

tasks.register("allTest") {
    dependsOn("app:testDebugUnitTest", "coreTest", "featureATest", "featureBTest")
}
