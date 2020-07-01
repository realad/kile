package node.pkg

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import node.getPropertyOrNull

data class Repository(var type: String? = null, var url: String? = null, var directory: String? = null) {
    companion object {
        fun fromJson(element: JsonElement): Repository =
            Repository(
                element.getPropertyOrNull("type"),
                element.getPropertyOrNull("url"),
                element.getPropertyOrNull("directory")
            )
    }

    fun toJson(): JsonObject {
        return JsonObject().also { obj ->
            type?.let { obj.addProperty("type", it) }
            url?.let { obj.addProperty("url", it) }
            directory?.let { obj.addProperty("directory", it) }
        }
    }
}
