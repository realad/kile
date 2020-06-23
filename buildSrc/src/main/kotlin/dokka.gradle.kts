import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("org.jetbrains.dokka")
}

subprojects {
    val subproject = this
    apply<DokkaPlugin>()

    tasks {
        val dokka by getting(DokkaTask::class) {
            outputFormat = "jekyll"
            outputDirectory = "$rootDir/docs/pages/kdoc"

            multiplatform {
                val common by creating {
                    moduleName = subproject.name
                    reportUndocumented = false
                }
                val js by creating {
                    moduleName = subproject.name
                    reportUndocumented = false
                }
                val jvm by creating {
                    moduleName = subproject.name
                    reportUndocumented = false
                }
            }
        }
    }
}
