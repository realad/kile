package io.realad.kile.error

/**
 * An abstraction of errors when working with the file system.
 *
 * @property operation an operation that was performed when an error was received.
 */
abstract class FilesystemOperationError constructor(
    private val operation: Operation,
    message: String,
    previous: FilesystemError?
): FilesystemError(message, previous) {
    enum class Operation {
        READ,
        RETRIEVE_METADATA
    }

    /**
     * Returns an operation that was performed when an error was received
     *
     * @return an operation that was performed when an error was received
     */
    fun getOperation(): Operation = operation
}
