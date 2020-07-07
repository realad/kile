package io.realad.kile

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * This interface contains everything to read from and explore a filesystem.
 */
interface KileReader {

    /**
     * Return a list of contents at the specified path.
     *
     * @param path path to content.
     * @return a list of attributes if the content exists, or an empty list if the content is missing, either returns an error.
     */
    fun listContents(path: String): Either<FilesystemError, List<KileAttributes>>

    /**
     *
     *
     * @param path the path to the file.
     */
    fun fileExists(path: String): Either<FilesystemError, Boolean>

}
