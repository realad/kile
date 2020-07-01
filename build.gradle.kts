import node.pkg.Bugs
import node.pkg.PublishConfig
import node.pkg.Repository
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsSetupTask
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinPackageJsonTask
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    kotlin("multiplatform")
    detekt
    coverage
    dokka
    sonarqube
    versions
}

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

group = "io.realad.kile"
version = Ci.publishVersion.value

println("kile version: $version")

val githubOwner: String by project
val githubRepository: String by project
val githubRegistry: String by project
val githubToken = getPropertyOrEnv("githubToken", "REPOSITORY_PASSWORD")

val projectWebsite: String by project
val projectLicense: String by project
val projectIssues: String by project

fun Set<String>.forEachProject(f: Project.() -> Unit) = subprojects.filter { it.name in this }.forEach(f)

val allSubprojects = subprojects.map { it.name }.toSet()
val multiplatformSubprojects = allSubprojects

allSubprojects.forEachProject {
    group = rootProject.group
    version = rootProject.version

    repositories.addAll(rootProject.repositories)
}

multiplatformSubprojects.forEachProject {
    val subproject = this
    apply(plugin = "kotlin-multiplatform")

    kotlin {
        targets {
            js(IR) {
                moduleName = subproject.name
                useCommonJs()
                nodejs()
                binaries.executable()
            }
            jvm {
                compilations.all {
                    kotlinOptions {
                        jvmTarget = "1.8"
                    }
                }
            }
        }
        sourceSets {
            val commonMain by getting {
                dependencies {
                    api(kotlin("stdlib-common"))
                    api(kotlin("reflect"))
                }
            }

            val commonTest by getting {
                dependencies {
                    implementation(Libs.Kotest.core)
                    implementation(Libs.Kotest.assertionsCore)
                }
            }

            val jvmMain by getting {
                dependsOn(commonMain)
                dependencies {
                    api(kotlin("stdlib-jdk8"))
                }
            }

            val jvmTest by getting {
                dependsOn(commonTest)
                dependencies {
                    implementation(Libs.Kotest.runnerJUnit)
                    implementation(Libs.Kotest.core)
                    implementation(Libs.Kotest.assertionsCore)
                }
            }

            val jsMain by getting {
                dependsOn(commonMain)
                dependencies {
                    implementation(kotlin("stdlib-js"))
                }
            }

            val jsTest by getting {
                dependsOn(commonTest)
                dependencies {
                    implementation(Libs.Kotest.core)
                    implementation(Libs.Kotest.assertionsCore)
                }
            }
        }
    }

    configureJsPackage()
}

fun Project.configureJsPackage(packageJsonTask: String = "jsPackageJson", compileTask: String = "jsMainClasses") {
    apply<node.NpmPublishPlugin>()

    configure<node.NpmPublishExtension> {
        nodeRoot = rootProject.tasks.withType<NodeJsSetupTask>().asSequence().map { it.destination }.first()
        token = githubToken
        registry = githubRegistry
        packageJson = tasks.getByName<KotlinPackageJsonTask>(packageJsonTask).packageJson
        nodeSetupTask = rootProject.tasks.getByName("kotlinNodeJsSetup").path
        jsCompileTask = compileTask
        jsSourcesDir = tasks.withType<Kotlin2JsCompile>().asSequence().filter { "Test" !in it.name }
            .map { it.outputFile.parentFile }.first()
        updatePackageJson {
            name = "@$githubOwner/$name"
            version = version?.substringBefore('+')
            homepage = projectWebsite
            bugs = Bugs(projectIssues)
            license = projectLicense
            dependencies = dependencies?.mapKeys {
                if ("kile" in it.key) "@$githubOwner/${it.key}" else it.key
            }?.mapValues {
                if ("kile" in it.key) it.value.substringBefore('+') else it.value
            }?.toMutableMap()
            publishConfig = PublishConfig("https://$githubRegistry/")
            repository = Repository("git", "ssh://git@github.com/$githubOwner/$githubRepository.git")
        }
    }
}
