package io.realad.kile

interface StorageAttributes {

    enum class Type {
        FILE, DIRECTORY
    }

    fun getPath(): String

    fun getType(): Type

}
