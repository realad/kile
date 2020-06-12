plugins {
    kotlin("multiplatform")
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
    }

    group = "io.realad.kile"
    version = "0.0.0"
}

subprojects {
    apply{
        plugin("kotlin-multiplatform")
    }
}
