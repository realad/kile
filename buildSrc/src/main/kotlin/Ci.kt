object Ci {
    private const val releaseVersion = "0.0.2"

    private val isGithub = System.getenv("GITHUB_ACTIONS") == "true"
    private val numberOfCommitsSinceLastTag: String = System.getenv("NUMBER_OF_COMMITS_SINCE_LAST_TAG") ?: "0"
    val isThisBuildForRelease = !isGithub
    private val snapshotVersion = lazy { "$releaseVersion.${numberOfCommitsSinceLastTag}-SNAPSHOT" }
    val publishVersion = lazy { if (isThisBuildForRelease) releaseVersion else snapshotVersion.value }
}
