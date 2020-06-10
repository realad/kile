import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    jacoco
    kotlin("multiplatform") version Libs.kotlinVersion
    id("org.sonarqube") version Libs.sonarqubeVersion
    id("io.gitlab.arturbosch.detekt") version Libs.detektVersion
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
        property("sonar.kotlin.detekt.reportPaths", "$buildDir/reports/detekt/detekt.xml")
    }
}

tasks {
    withType<DokkaTask> {
        outputFormat = "html"
        outputDirectory = "$buildDir/dokka"
        subProjects = listOf("core", "fp")
    }

    // Inspired by https://docs.gradle.org/6.5/samples/sample_jvm_multi_project_with_code_coverage.html
    val jacocoReport by register<JacocoReport>("jacocoReport") {
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

subprojects {
    val subproject = this
    apply<DetektPlugin>()
    apply<JacocoPlugin>()

    jacoco {
        reportsDir = file("${subproject.buildDir}/reports/jacoco/")
    }

    sonarqube {
        properties {
            val dirs = file("src").listFiles()
                ?.mapNotNull { it.path.substring("${subproject.projectDir.path}/".length) } ?: listOf()

            val sources = dirs.filter { it.contains("Main") }
            val tests = dirs.filter { it.contains("Test") }

            property("sonar.sources", sources.joinToString(","))
            property("sonar.tests", tests.joinToString(","))
            property(
                "sonar.exclusions", "**/jsMain/**,**/jsTest/**," +
                    "**/src/commonMain/kotlin/io/realad/kile/adapters/ftp/FtpConnectionOptions.kt," +
                    "**/src/commonMain/kotlin/io/realad/kile/adapters/ftp/FtpConnectionProvider.kt"
            )
            property("sonar.kotlin.detekt.reportPaths", "${subproject.buildDir}/reports/detekt/detekt.xml")
        }
    }

    tasks {
        withType<Detekt> {
            parallel = true
            ignoreFailures = true
            setSource(files("src"))
            include("**/*.kt")
            exclude("**/resources/**")
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
