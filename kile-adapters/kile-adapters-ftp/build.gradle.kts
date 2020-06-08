plugins {
    jacoco
    kotlin("multiplatform")
    id("org.sonarqube")
}

repositories {
    mavenCentral()
}

sonarqube {
    properties {
        property("sonar.sources", "src/commonMain,src/jvmMain")
        property("sonar.exclusions",
            "src/commonMain/kotlin/io/realad/kile/adapters/ftp/FtpConnectionOptions.kt," +
            "src/commonMain/kotlin/io/realad/kile/adapters/ftp/FtpConnectionProvider.kt")
    }
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
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(project(Projects.KileCore))
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
                implementation(Libs.Napier.js)
                implementation(npm("ftp"))
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
                implementation(Libs.ApacheCommons.net)
                implementation(Libs.Napier.jvm)
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
