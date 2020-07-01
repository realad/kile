kotlin {
    sourceSets {
        val commonMain by getting {}

        val commonTest by getting {}

        val jvmMain by getting {
            dependsOn(commonMain)
        }

        val jvmTest by getting {
            dependsOn(commonTest)
        }

        val jsMain by getting {
            dependsOn(commonMain)
        }

        val jsTest by getting {
            dependsOn(commonTest)
        }
    }
}

tasks {
    withType(AbstractTestTask::class) {
        testLogging {
            showExceptions = true
            showStandardStreams = false
            events = setOf(
                org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
                org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
            )
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }

    named<Test>("jvmTest") {
        useJUnitPlatform()
    }
}

apply(plugin = "publish-mpp")
