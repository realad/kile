package io.realad.kile

/**
 * Interface for file and directory attributes.
 */
interface KileAttributes {

    enum class Type {
        FILE, DIRECTORY
    }

    fun getPath(): String

    fun getType(): Type

}
