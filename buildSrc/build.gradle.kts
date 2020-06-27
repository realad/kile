plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}

/**
 * Information about gradle plugins and their versions.
 */
object Plugins {

    /**
     * https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-gradle-plugin
     */
    object Kotlin {
        private const val version = "1.4-M2"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    /**
     * https://plugins.gradle.org/plugin/io.gitlab.arturbosch.detekt
     */
    object Detekt {
        private const val version = "1.9.1"
        const val gradlePlugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$version"
    }

    /**
     * https://plugins.gradle.org/plugin/org.jetbrains.dokka
     */
    object Dokka {
        private const val version = "0.10.1"
        const val gradlePlugin = "org.jetbrains.dokka:dokka-gradle-plugin:$version"
    }

    /**
     * https://plugins.gradle.org/plugin/org.sonarqube
     */
    object SonarQube {
        private const val version = "3.0"
        const val gradlePlugin = "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:$version"
    }

    /**
     * https://plugins.gradle.org/plugin/com.github.ben-manes.versions
     */
    object GradleVersions {
        private const val version = "0.28.0"
        const val gradlePlugin = "com.github.ben-manes:gradle-versions-plugin:$version"
    }

}

dependencies {
    implementation(Plugins.Kotlin.gradlePlugin)
    implementation(Plugins.Detekt.gradlePlugin)
    implementation(Plugins.Dokka.gradlePlugin)
    implementation(Plugins.SonarQube.gradlePlugin)
    implementation(Plugins.GradleVersions.gradlePlugin)
}
