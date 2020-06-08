package io.realad.kile.error

abstract class FilesystemOperationError constructor(
    private val operation: Operation,
    message: String,
    previous: FilesystemError?
): FilesystemError(message, previous) {
    enum class Operation {
        READ,
        RETRIEVE_METADATA
    }

    fun getOperation(): Operation = operation
}
