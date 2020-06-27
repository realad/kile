plugins {
    detekt
    coverage
    dokka
    sonarqube
    versions
}

// Configure existing Dokka task to output HTML to typical Javadoc directory
tasks.dokka {
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
        }
    }

    group = "io.realad.kile"
    version = Ci.publishVersion.value
}

subprojects {
    apply{
        plugin("kotlin-multiplatform")
    }
}
