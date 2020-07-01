package node.pkg

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import node.getPropertyOrNull

data class Bugs(var url: String? = null) {
    companion object {
        fun fromJson(element: JsonElement): Bugs =
            Bugs(
                element.getPropertyOrNull("url")
            )
    }

    fun toJson(): JsonObject {
        return JsonObject().also { obj ->
            url?.let { obj.addProperty("url", it) }
        }
    }
}
