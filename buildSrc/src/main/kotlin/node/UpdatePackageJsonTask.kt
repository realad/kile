package node

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import node.pkg.PackageJson
import org.gradle.api.Action
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.FileReader
import java.io.FileWriter

open class UpdatePackageJsonTask : DefaultTask() {

    private val gson = GsonBuilder().setPrettyPrinting().create()
    private var packageJson: PackageJson? = null
    private lateinit var packageJsonRaw: JsonObject

    internal var updateActions: List<Action<PackageJson>> = emptyList()
        @Internal
        get() = field
        set(value) {
            field = value
        }

    internal var rawUpdateActions: List<Action<JsonObject>> = emptyList()
        @Internal
        get() = field
        set(value) {
            field = value
        }

    @Internal
    lateinit var packageJsonFile: File

    @TaskAction
    fun lift() {
        if (!packageJsonFile.exists()) {
            error("File ${packageJsonFile.path} does not exist")
        }
        resolve()
        performUpdate()
        save()
    }

    private fun resolve() {
        packageJsonRaw = gson.fromJson(FileReader(packageJsonFile), JsonObject::class.java)
        packageJson = try {
            PackageJson.fromJson(packageJsonRaw)
        } catch (_: Throwable) {
            System.err.println("Cannot parse $packageJsonFile as a data class, use raw enrichment")
            null
        }
    }

    private fun performUpdate() {
        if (packageJson == null) {
            rawUpdateActions.forEach { it.execute(packageJsonRaw) }
        } else {
            updateActions.forEach { it.execute(packageJson!!) }
        }
    }

    private fun save() {
        FileWriter(packageJsonFile).use {
            gson.toJson(packageJson?.toJson() ?: packageJsonRaw, it)
        }
    }
}
