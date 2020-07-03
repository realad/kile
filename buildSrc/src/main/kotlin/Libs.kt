object Libs {

    object Kotest {
        private const val version = "4.1.1"
        const val core = "io.kotest:kotest-core:$version"
        const val assertionsCore = "io.kotest:kotest-assertions-core:$version"
        const val runnerJUnit = "io.kotest:kotest-runner-junit5:$version"
    }

    object Mockk {
        private const val version = "1.10.0"
        const val mockk = "io.mockk:mockk:$version"
    }

    object MockFtpServer {
        private const val version = "2.7.1"
        const val server = "org.mockftpserver:MockFtpServer:$version"
    }

    object ApacheCommons {
        private const val netVersion = "3.6"
        private const val ioVersion = "2.7"
        const val net = "commons-net:commons-net:$netVersion"
        const val io = "commons-io:commons-io:$ioVersion"
    }

}
