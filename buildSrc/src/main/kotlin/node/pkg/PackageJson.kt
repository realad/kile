package node.pkg

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import node.asPropertyMapOrNull
import node.getOrNull
import node.getPropertyOrNull
import node.jsonObject

data class PackageJson(
    var name: String? = null,
    var main: String? = null,
    var version: String? = null,
    var dependencies: MutableMap<String, String>? = null,
    var devDependencies: MutableMap<String, String>? = null,
    var homepage: String? = null,
    var bugs: Bugs? = null,
    var license: String? = null,
    var publishConfig: PublishConfig? = null,
    var repository: Repository? = null
) {
    companion object {
        fun fromJson(element: JsonElement): PackageJson =
            PackageJson(
                name = element.getPropertyOrNull("name"),
                main = element.getPropertyOrNull("main"),
                version = element.getPropertyOrNull("version"),
                homepage = element.getPropertyOrNull("homepage"),
                bugs = element.getOrNull("bugs")?.let { Bugs.fromJson(it) },
                license = element.getPropertyOrNull("license"),
                dependencies = element.getOrNull("dependencies")?.asPropertyMapOrNull(),
                devDependencies = element.getOrNull("devDependencies")?.asPropertyMapOrNull(),
                publishConfig = element.getOrNull("publishConfig")?.let { PublishConfig.fromJson(it) },
                repository = element.getOrNull("repository")?.let { Repository.fromJson(it) }
            )
    }

    fun toJson(): JsonObject {
        return JsonObject().also { obj ->
            name?.let { obj.addProperty("name", it) }
            main?.let { obj.addProperty("main", it) }
            version?.let { obj.addProperty("version", it) }
            homepage?.let { obj.addProperty("homepage", it) }
            license?.let { obj.addProperty("license", it) }
            bugs?.let { obj.add("bugs", it.toJson()) }
            dependencies?.let { obj.add("dependencies", jsonObject(it)) }
            devDependencies?.let { obj.add("devDependencies", jsonObject(it)) }
            publishConfig?.let { obj.add("publishConfig", it.toJson()) }
            repository?.let { obj.add("repository", it.toJson()) }
        }
    }
}
