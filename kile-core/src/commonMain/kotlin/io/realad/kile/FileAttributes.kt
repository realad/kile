package io.realad.kile

/**
 * Attributes of the file.
 */
data class FileAttributes(
    private val path: String,
    private val fileSize: Long?
) : KileAttributes {

    enum class Attribute {
        PATH, FILE_SIZE
    }

    fun getFileSize() = fileSize

    override fun getPath() = path

    override fun getType() = KileAttributes.Type.FILE

}
