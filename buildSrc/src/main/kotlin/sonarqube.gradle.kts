plugins {
    id("org.sonarqube")
}

sonarqube {
    properties {
        property("sonar.organization", "realad")
        property("sonar.projectKey", "io.realad.kile")
        property("sonar.java.coveragePlugin", "jacoco")
        property(
            "sonar.coverage.jacoco.xmlReportPaths",
            "$buildDir/reports/jacoco/jacocoTestReport/jacocoTestReport.xml"
        )
        property("sonar.kotlin.detekt.reportPaths", "$buildDir/reports/detekt/detekt.xml")
    }
}

subprojects {
    val subproject = this

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
                    "**/src/commonMain/kotlin/io/realad/kile/adapters/ftp/FtpConnectionProvider.kt," +
                    "**/src/commonMain/kotlin/io/realad/kile/adapters/local/FileUtils.kt"
            )
            property("sonar.kotlin.detekt.reportPaths", "${subproject.buildDir}/reports/detekt/detekt.xml")
        }
    }
}
