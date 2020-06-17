import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin

plugins {
    id("io.gitlab.arturbosch.detekt")
}

subprojects {
    apply<DetektPlugin>()

    tasks {
        withType<Detekt> {
            parallel = true
            ignoreFailures = true
            setSource(files("src"))
            include("**/*.kt")
            exclude("**/resources/**")
        }
    }
}
