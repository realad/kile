package node

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Exec

class NpmPublishPlugin : Plugin<Project> {

    private val gradleGroup = "nodejs"
    private lateinit var extension: NpmPublishExtension

    private fun Project.createSetRegistryTokenTask(name: String): DefaultTask {
        val setToken = tasks.maybeCreate("${name}SetRegistryToken", Exec::class.java).also {
            it.group = gradleGroup
            it.standardOutput = System.out
        }
        extension.onExtensionChanged.add {
            setToken.executable = node?.absolutePath
            setToken.setArgs(listOf(npm, "set", "//$registry/:_authToken", token))
            nodeSetupTask?.let {
                setToken.dependsOn(it)
            }
        }
        return setToken
    }

    private fun Project.createNpmPublishTask(name: String): Exec {
        val publish = tasks.maybeCreate(name, Exec::class.java).also {
            it.group = gradleGroup
            it.standardOutput = System.out
        }
        extension.onExtensionChanged.add {
            publish.executable = node?.absolutePath
            publish.setArgs(listOf(npm, "publish", npmProject, "--access", "public"))
            nodeSetupTask?.let { publish.dependsOn(it) }
            jsCompileTask?.let { publish.dependsOn(it) }
        }
        return publish
    }

    private fun Project.createUpdatePackageJsonTask(name: String): UpdatePackageJsonTask {
        val updatePackageJson = tasks.maybeCreate(name, UpdatePackageJsonTask::class.java).also {
            it.group = gradleGroup
        }
        extension.onExtensionChanged.add {
            packageJson?.let { updatePackageJson.packageJsonFile = it }
            updatePackageJson.updateActions = packageJsonUpdateActions
            updatePackageJson.rawUpdateActions = packageJsonRawUpdateActions
            jsCompileTask?.let { updatePackageJson.dependsOn(it) }
        }
        return updatePackageJson
    }

    override fun apply(target: Project) {
        extension = target.extensions.create("npmPublishExtension", NpmPublishExtension::class.java)
        val login = target.createSetRegistryTokenTask("npm")
        val enrichPackageJson = target.createUpdatePackageJsonTask("updatePackageJson")
        val publish = target.createNpmPublishTask("npmPublish")
        publish.dependsOn(login)
        publish.dependsOn(enrichPackageJson)
    }
}
