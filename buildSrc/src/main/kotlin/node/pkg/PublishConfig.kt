package node.pkg

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import node.getPropertyOrNull

data class PublishConfig(var registry: String? = null) {
    companion object {
        fun fromJson(element: JsonElement): PublishConfig =
            PublishConfig(
                element.getPropertyOrNull("registry")
            )
    }

    fun toJson(): JsonObject {
        return JsonObject().also { obj ->
            registry?.let { obj.addProperty("registry", it) }
        }
    }
}
