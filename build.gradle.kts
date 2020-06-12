plugins {
    common
    detekt
    coverage
    dokka
    sonarqube
    versions
}

repositories {
    jcenter()
    mavenCentral()
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
    }

    group = "io.realad.kile"
    version = Ci.publishVersion.value
}
