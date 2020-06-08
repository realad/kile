package io.realad.kile

class FileAttributes(
    private val path: String,
    private val fileSize: Long?
) : StorageAttributes {

    enum class Attribute {
        PATH, FILE_SIZE
    }

    fun getFileSize(): Long? = fileSize

    override fun getPath(): String = path

    override fun getType(): StorageAttributes.Type = StorageAttributes.Type.FILE

}
