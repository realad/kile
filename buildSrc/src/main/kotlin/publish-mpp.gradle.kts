apply {
    plugin("java")
    plugin("java-library")
    plugin("signing")
    plugin("maven-publish")
}

repositories {
    mavenCentral()
}

val repositoryUsername: String by project
val repositoryPassword: String by project

fun Project.publishing(action: PublishingExtension.() -> Unit) =
    configure(action)

fun Project.signing(configure: SigningExtension.() -> Unit): Unit =
    configure(configure)

val dokka = tasks.named("dokka")

val publications: PublicationContainer = (extensions.getByName("publishing") as PublishingExtension).publications

signing {
    useGpgCmd()
    if (Ci.isReleaseVersion)
        sign(publications)
}

// Create dokka Jar task from dokka task output
val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    archiveClassifier.set("javadoc")
    from(dokka)
}

publishing {
    repositories {
        maven {
            val releasesRepoUrl = "https://maven.pkg.github.com/RealAd/kile"
            val snapshotsRepoUrl = "https://maven.pkg.github.com/RealAd/kile"
            name = "GitHubPackages"
            url = uri(if (Ci.isReleaseVersion) releasesRepoUrl else snapshotsRepoUrl)
            credentials {
                username = System.getenv("REPOSITORY_USERNAME") ?: repositoryUsername
                password = System.getenv("REPOSITORY_PASSWORD") ?: repositoryPassword
            }
        }
    }

    publications.withType<MavenPublication>().forEach {
        it.apply {
            artifact(dokkaJar)
            pom {
                name.set("kile")
                description.set("Abstraction for the filesystem.")
                url.set("http://github.com/RealAd/kile")

                scm {
                    connection.set("scm:git:http://github.com/RealAd/kile/")
                    developerConnection.set("scm:git:http://github.com/AndrewKochura/")
                    url.set("https://github.com/RealAd/kile")
                }

                licenses {
                    license {
                        name.set("The Apache 2.0 License")
                        url.set("https://opensource.org/licenses/Apache-2.0")
                    }
                }

                developers {
                    developer {
                        id.set("AndrewKochura")
                        name.set("Andrew Kochura")
                        email.set("a.kochura@realad.io")
                        organization.set("RealAd")
                        organizationUrl.set("https://github.com/RealAd")
                    }
                }
            }
        }
    }
}
