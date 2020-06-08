object Libs {

    const val kotlinVersion = "1.3.72"
    const val dokkaVersion = "0.10.1"
    const val gradleVersionsPluginVersion = "0.28.0"

    object Napier {
        private const val version = "1.3.0"
        const val common = "com.github.aakira:napier:$version"
        const val jvm = "com.github.aakira:napier-jvm:$version"
        const val js = "com.github.aakira:napier-js:$version"
    }

    object Kotest {
        private const val version = "4.0.5"
        const val core = "io.kotest:kotest-core:$version"
        const val assertionsCore = "io.kotest:kotest-assertions-core:$version"
        const val runnerJUnit = "io.kotest:kotest-runner-junit5:$version"
    }

    object Mockk {
        private const val version = "1.10.0"
        const val mockk = "io.mockk:mockk:$version"
    }

    object ApacheCommons {
        private const val version = "3.6"
        const val net = "commons-net:commons-net:$version"
    }

}
