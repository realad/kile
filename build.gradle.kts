import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    jacoco
    kotlin("multiplatform") version Libs.kotlinVersion
    id("org.sonarqube") version "3.0"
    id("org.jetbrains.dokka") version Libs.dokkaVersion
    id("com.github.ben-manes.versions") version Libs.gradleVersionsPluginVersion
}

jacoco {
    toolVersion = "0.8.5"
}

sonarqube {
    properties {
        property("sonar.organization", "realad")
        property("sonar.projectKey", "io.realad.kile")
        property("sonar.java.coveragePlugin", "jacoco")
        property("sonar.coverage.jacoco.xmlReportPaths", "$buildDir/reports/jacoco/jacocoReport/jacocoReport.xml")
    }
}

tasks {
    withType<DokkaTask> {
        outputFormat = "html"
        outputDirectory = "$buildDir/dokka"
        subProjects = listOf("core", "fp")
    }

    // Inspired by https://docs.gradle.org/6.5/samples/sample_jvm_multi_project_with_code_coverage.html
    register<JacocoReport>("jacocoReport") {
        val excludes = listOf("**/*Test*.*")
        val sourceDirs = arrayListOf<Any>()
        val classDirs = arrayListOf<Any>()
        val executionDataDirs = arrayListOf<Any>()
        subprojects
            .filter { subproject -> subproject.plugins.hasPlugin(JacocoPlugin::class) }
            .forEach { subproject ->
                sourceDirs.addAll(subproject.projectDir.listFiles { file -> file.name == "src" }
                    ?.flatMap { src -> src.listFiles { file -> file.name.endsWith("Main") }?.toList() ?: listOf() }
                    ?.flatMap { main -> main.listFiles { file -> file.name == "kotlin" }?.toList() ?: listOf() }
                    ?.map { kotlin -> kotlin.path } ?: listOf())
                classDirs.add(fileTree("${subproject.buildDir}/classes/kotlin/jvm/").exclude(excludes))
                executionDataDirs.add(fileTree("${subproject.buildDir}/jacoco/").include("*.exec"))
                subproject.tasks.matching { it.extensions.findByType<JacocoTaskExtension>() != null }.forEach {
                    rootProject.tasks["jacocoReport"].dependsOn(it)
                }
            }
        sourceDirectories.setFrom(files(sourceDirs))
        classDirectories.setFrom(files(classDirs))
        executionData.setFrom(files(executionDataDirs))
        reports {
            xml.isEnabled = true
            html.isEnabled = true
        }
    }
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        google()
    }

    group = "io.realad.kile"
    version = "0.0.0"
}
