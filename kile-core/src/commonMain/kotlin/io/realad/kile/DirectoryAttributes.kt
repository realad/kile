package io.realad.kile

class DirectoryAttributes(
    private val path: String
) : StorageAttributes {

    override fun getPath(): String = path

    override fun getType(): StorageAttributes.Type = StorageAttributes.Type.DIRECTORY

}
