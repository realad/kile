package node

import com.google.gson.JsonElement
import com.google.gson.JsonObject

fun jsonObject(keys: Map<String, String>): JsonObject =
    JsonObject().apply { keys.forEach { addProperty(it.key, it.value) } }

fun JsonElement.getPropertyOrNull(key: String): String? =
    getOrNull(key)?.asString

fun JsonElement.getOrNull(key: String): JsonElement? =
    if (this is JsonObject && has(key)) get(key)
    else null

fun JsonElement.asPropertyMapOrNull(): MutableMap<String, String>? =
    if (this is JsonObject) keySet().map { it to this@asPropertyMapOrNull[it].asString }.toMap(mutableMapOf())
    else null
