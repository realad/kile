package io.realad.kile.adapters.local

import io.realad.kile.DirectoryAttributes
import io.realad.kile.FileAttributes
import io.realad.kile.KileAttributes
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either
import io.realad.kile.fp.right
import java.io.File

/**
 * General file manipulation utilities.
 */
actual class FileUtils {

    /**
     * Function for displaying catalogs and content.
     */
    actual fun listContents(path: String): Either<FilesystemError, List<KileAttributes>> = File(path).listFiles()
        .orEmpty().map {
            if (it.isFile) {
                FileAttributes(it.path, it.length())
            } else {
                DirectoryAttributes(it.path)
            }
        }.right()

    /**
     * Function to check if a file exists.
     */
    actual fun fileExists(location: String): Either<FilesystemError, Boolean> {
        TODO("Not yet implemented")
    }

}
