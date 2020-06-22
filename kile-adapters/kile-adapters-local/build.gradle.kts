repositories {
    mavenCentral()
}

kotlin {
    targets {
        js {
            nodejs()
            useCommonJs()
        }
        jvm {
            compilations.all {
                kotlinOptions {
                    jvmTarget = "1.8"
                }
            }
        }
    }

    targets.all {
        compilations.all {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(project(Projects.KileAdapters))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Libs.Kotest.core)
                implementation(Libs.Kotest.assertionsCore)
            }
        }

        val jsMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }

        val jsTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(Libs.Kotest.core)
                implementation(Libs.Kotest.assertionsCore)
            }
        }

        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }

        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(Libs.Kotest.runnerJUnit)
                implementation(Libs.Kotest.core)
                implementation(Libs.Kotest.assertionsCore)
                implementation(Libs.Mockk.mockk)
                implementation(Libs.MockFtpServer.server)
            }
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
