import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("org.jetbrains.dokka")
}

subprojects {
    apply<DokkaPlugin>()

    tasks {
        val dokka by getting(DokkaTask::class) {
            outputDirectory = "$buildDir/dokka"
            outputFormat = "html"

            multiplatform {
                val js by creating
                val jvm by creating
            }
        }
    }
}
