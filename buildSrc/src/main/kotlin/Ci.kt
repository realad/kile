object Ci {
    private val isGithub = System.getenv("GITHUB_ACTIONS") == "true"
    private val githubBuildNumber: String = System.getenv("GITHUB_RUN_NUMBER") ?: "0"
}
