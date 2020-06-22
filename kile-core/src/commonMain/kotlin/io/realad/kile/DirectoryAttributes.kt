package io.realad.kile

/**
 * Attributes of the directory.
 */
data class DirectoryAttributes(
    private val path: String
) : KileAttributes {

    override fun getPath() = path

    override fun getType() = KileAttributes.Type.DIRECTORY

}
