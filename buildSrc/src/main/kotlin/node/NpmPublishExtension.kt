package node

import com.google.gson.JsonObject
import node.pkg.PackageJson
import org.gradle.api.Action
import java.io.File

open class NpmPublishExtension {

    internal var onExtensionChanged: MutableList<NpmPublishExtension.() -> Unit> = mutableListOf()

    var nodeRoot: File? = null
        set(value) {
            field = value
            node = null
            onExtensionChanged.forEach { it(this) }
        }

    var nodeSetupTask: String? = null
        set(value) {
            field = value
            onExtensionChanged.forEach { it(this) }
        }

    var jsCompileTask: String? = null
        set(value) {
            field = value
            onExtensionChanged.forEach { it(this) }
        }

    var packageJson: File? = null
        set(value) {
            field = value
            onExtensionChanged.forEach { it(this) }
        }

    var token: String = ""
        set(value) {
            field = value
            onExtensionChanged.forEach { it(this) }
        }

    var registry = defaultRegistry
        set(value) {
            field = value
            onExtensionChanged.forEach { it(this) }
        }

    internal var node: File? = null
        get() {
            if (field == null) {
                field = possibleNodePaths.map { nodeRoot?.resolve(it) }.find { it?.exists() ?: false }
            }
            return field
        }

    internal var npm: File? = null
        get() {
            if (field == null) {
                field = possibleNpmPaths.map { nodeRoot?.resolve(it) }.find { it?.exists() ?: false }
            }
            return field
        }

    internal val npmProject: File?
        get() = packageJson?.parentFile

    var jsSourcesDir: File? = null
        set(value) {
            field = value
            onExtensionChanged.forEach { it(this) }
        }

    private val _packageJsonUpdateActions: MutableList<Action<PackageJson>> = mutableListOf()
    private val _packageJsonRawUpdateActions: MutableList<Action<JsonObject>> = mutableListOf()

    internal val packageJsonUpdateActions: List<Action<PackageJson>>
        get() = _packageJsonUpdateActions.toList()

    internal val packageJsonRawUpdateActions: List<Action<JsonObject>>
        get() = _packageJsonRawUpdateActions.toList()

    fun updatePackageJson(action: Action<PackageJson>) {
        _packageJsonUpdateActions.add(action)
        onExtensionChanged.forEach { it(this) }
    }

    fun updatePackageJsonRaw(action: Action<JsonObject>) {
        _packageJsonRawUpdateActions.add(action)
        onExtensionChanged.forEach { it(this) }
    }

    companion object {
        private const val defaultRegistry = "registry.npmjs.org"
        private const val npmScriptSubpath = "node_modules/npm/bin/npm-cli.js"

        private val possibleNodePaths: Sequence<String> =
            sequenceOf("bin/node", "node")

        private val possibleNpmPaths: Sequence<String> =
            sequenceOf("lib/", "").map { it + npmScriptSubpath }
    }
}
