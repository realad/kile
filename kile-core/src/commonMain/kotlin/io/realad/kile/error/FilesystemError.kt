package io.realad.kile.error

open class FilesystemError(
    private val message: String,
    private val previous: FilesystemError? = null
) {

    fun getMessage(): String = message

    fun getPrevious(): FilesystemError? = previous

}
