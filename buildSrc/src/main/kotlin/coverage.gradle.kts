plugins {
    jacoco
}

jacoco {
    toolVersion = "0.8.5"
}

tasks {
    // Inspired by https://docs.gradle.org/6.5/samples/sample_jvm_multi_project_with_code_coverage.html
    val jacocoTestReport by register<JacocoReport>("jacocoTestReport") {
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
                    rootProject.tasks["jacocoTestReport"].dependsOn(it)
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
    apply<JacocoPlugin>()

    jacoco {
        reportsDir = file("${subproject.buildDir}/reports/jacoco/")
    }
}
