package io.realad.kile

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * Base interface for any file system.
 */
interface KileAdapter {

    /**
     * Function for displaying catalogs and content.
     */
    fun listContents(path: String): Either<FilesystemError, List<KileAttributes>>

    /**
     * Function to check if a file exists.
     */
    fun fileExists(path: String): Either<FilesystemError, Boolean>

}
