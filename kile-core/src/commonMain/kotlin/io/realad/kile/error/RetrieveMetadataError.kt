package io.realad.kile.error

import io.realad.kile.FileAttributes

/**
 * Error retrieving file or directory metadata.
 */
class RetrieveMetadataError private constructor(
    operation: Operation,
    private val location: String,
    private val metadataType: FileAttributes.Attribute,
    message: String,
    previous: FilesystemError?
) : FilesystemOperationError(operation, message, previous) {

    fun getLocation(): String = location

    fun getMetadataType(): FileAttributes.Attribute = metadataType

    companion object {
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
