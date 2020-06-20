object Ci {
    private val isGithub = System.getenv("GITHUB_ACTIONS") == "true"
    private val githubBuildNumber: String = System.getenv("GITHUB_RUN_NUMBER") ?: "0"
    val isReleaseVersion = !isGithub

    val ideaActive = System.getProperty("idea.active") == "true"
    val os = org.gradle.internal.os.OperatingSystem.current()

    private val snapshotBuildNumber = lazy {
        Runtime.getRuntime().exec("git rev-list --count master")
        val number = System.`in`.bufferedReader().read()
        println("Snapshot build number: $number")
        number
    }

    private val numberOfCommitsSinceLastTag = lazy {
        Runtime.getRuntime().exec("git rev-list --count \$(git describe --tags \$(git rev-list --tags --max-count=1))")
        System.`in`.bufferedReader().read()
    }

    private const val releaseVersion = "0.0.2"
    private val snapshotVersion = lazy { "$releaseVersion.$numberOfCommitsSinceLastTag-SNAPSHOT" }
    val publishVersion = lazy { if (isReleaseVersion) releaseVersion else snapshotVersion.value }
}
