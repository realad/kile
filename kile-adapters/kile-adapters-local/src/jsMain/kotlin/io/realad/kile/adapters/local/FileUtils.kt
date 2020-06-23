package io.realad.kile.adapters.local

import io.realad.kile.KileAttributes
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * General file manipulation utilities.
 */
actual class FileUtils {

    /**
     * Returns an array of attributes denoting the files in the
     * directory denoted by this abstract pathname.
     *
     * @return An array of attributes denoting the files and directories
     * in the directory denoted by the pathname. The array will be empty
     * if the directory is empty.
     */
    actual fun listContents(pathname: String): Either<FilesystemError, List<KileAttributes>> {
        TODO("Not yet implemented")
    }

    /**
     * Tests whether the file or directory denoted by this abstract pathname
     * exists.
     *
     * @return {@code true} if and only if the file or directory denoted
     * by this abstract pathname exists, {@code false} otherwise
     */
    actual fun fileExists(pathname: String): Either<FilesystemError, Boolean> {
        TODO("Not yet implemented")
    }

}
