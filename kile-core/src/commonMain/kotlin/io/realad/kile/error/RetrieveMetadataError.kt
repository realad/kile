package io.realad.kile.error

import io.realad.kile.FileAttributes

/**
 * Class for representation an error received during retrieving metadata from file or directory.
 *
 * @property location the location where this error retrieved
 * @property metadataType the type of metadata that was attempted to be read when this error was received
 */
class RetrieveMetadataError private constructor(
    operation: Operation,
    private val location: String,
    private val metadataType: FileAttributes.Attribute,
    message: String,
    previous: FilesystemError?
) : FilesystemOperationError(operation, message, previous) {

    /**
     * Return the location where this error retrieved
     *
     * @return the location where this error retrieved
     */
    fun getLocation(): String = location

    /**
     * Returns the type of metadata that was attempted to be read when this error was received
     *
     * @return the type of metadata that was attempted to be read when this error was received
     */
    fun getMetadataType(): FileAttributes.Attribute = metadataType

    companion object {

        /**
         * Returns an error instance that represents an error when the file size cannot be read
         *
         * @param location the location where this error retrieved
         * @param message a message of the error
         * @param previous a previous error, null otherwise
         */
        fun fileSize(location: String, message: String, previous: FilesystemError? = null): RetrieveMetadataError {
            return create(Operation.RETRIEVE_METADATA, location, FileAttributes.Attribute.FILE_SIZE, message, previous)
        }

        private fun create(
            operation: Operation,
            location: String,
            metadataType: FileAttributes.Attribute,
            message: String,
            previous: FilesystemError?
        ): RetrieveMetadataError {
            return RetrieveMetadataError(operation, location, metadataType, message, previous)
        }
    }
}
