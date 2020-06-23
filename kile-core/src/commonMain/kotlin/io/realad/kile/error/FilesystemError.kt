package io.realad.kile.error

/**
 * Open representation of the file system error.
 *
 * @property message a message of the error
 * @property previous a previous error, may be null
 */
open class FilesystemError(
    private val message: String,
    private var previous: FilesystemError? = null
) {

    /**
     * Returns a message of the error
     *
     * @return a message of the error
     */
    fun getMessage(): String = message

    /**
     * Returns a previous error
     *
     * @return a previous error, null otherwise
     */
    fun getPrevious(): FilesystemError? = previous

    /**
     * Set a previous error
     *
     * @param error a previous error, may be null
     */
    fun setPrevious(error: FilesystemError?) {
        previous = error
    }

}
