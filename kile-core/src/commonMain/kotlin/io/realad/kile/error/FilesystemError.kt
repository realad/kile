package io.realad.kile.error

open class FilesystemError(
    private val message: String,
    private var previous: FilesystemError? = null
) {

    fun getMessage(): String = message

    fun getPrevious(): FilesystemError? = previous

    fun setPrevious(error: FilesystemError?) {
        previous = error
    }

}
