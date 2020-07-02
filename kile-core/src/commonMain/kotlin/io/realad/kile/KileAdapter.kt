package io.realad.kile

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Base interface for any file system.
 */
@ExperimentalJsExport
@JsExport
interface KileAdapter {

    /**
     * Function for displaying catalogs and content.
     */
    fun listContents(path: String): Either<FilesystemError, List<KileAttributes>>

    /**
     * Function to check if a file exists.
     */
    fun fileExists(location: String): Either<FilesystemError, Boolean>

}
