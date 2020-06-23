package io.realad.kile

/**
 * Interface for an entry attributes within a file system, representing a single file or directory.
 */
interface KileAttributes {

    enum class Type {
        FILE, DIRECTORY
    }

    /**
     * Return the path for this file system entry
     *
     * @return the path for this file system entry
     */
    fun getPath(): String

    /**
     * Return type of this entry represents a file directory
     *
     * @return {@code Type.FILE} if this file system entry is a file,
     * {@code Type.DIRECTORY} otherwise
     * @see Type
     */
    fun getType(): Type

}
