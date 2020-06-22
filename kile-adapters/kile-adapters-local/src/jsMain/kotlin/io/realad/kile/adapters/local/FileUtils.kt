package io.realad.kile.adapters.local

import io.realad.kile.KileAttributes
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * General file manipulation utilities.
 */
actual class FileUtils {

    /**
     * Function for displaying catalogs and content.
     */
    actual fun listContents(path: String): Either<FilesystemError, List<KileAttributes>> {
        TODO("Not yet implemented")
    }

    /**
     * Function to check if a file exists.
     */
    actual fun fileExists(location: String): Either<FilesystemError, Boolean> {
        TODO("Not yet implemented")
    }

}
