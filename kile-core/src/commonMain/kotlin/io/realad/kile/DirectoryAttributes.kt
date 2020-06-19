package io.realad.kile

/**
 * Attributes of the directory.
 */
class DirectoryAttributes(
    private val path: String
) : StorageAttributes {

    override fun getPath(): String = path

    override fun getType(): StorageAttributes.Type = StorageAttributes.Type.DIRECTORY

}
