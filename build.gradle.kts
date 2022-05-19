// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
    id("org.sonarqube") version "3.3"
}

buildscript {
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.1")
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.0")
    }
}

apply(plugin = "org.sonarqube")
apply(plugin = "kover")

tasks.koverMergedXmlReport {
    enabled = true

    includes = listOf("com.challenge.weather.*")
}

subprojects {
    sonarqube {
        properties {
            property("sonar.sourceEncoding", "UTF-8")
            property("sonar.sources", "$projectDir/src/main/java/")
            property("sonar.tests", "$projectDir/src/test/java/")
            property("sonar.exclusions", "**/di/*")
            property(
                "sonar.coverage.jacoco.xmlReportPaths",
                "$buildDir/reports/kover/project-xml/report.xml"
            )
        }
    }
}

project.tasks["sonarqube"].dependsOn("koverMergedXmlReport")

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
