kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(Projects.KileAdapters))
            }
        }

        val commonTest by getting {}

        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Libs.ApacheCommons.net)
            }
        }

        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(Libs.Mockk.mockk)
                implementation(Libs.MockFtpServer.server)
            }
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
