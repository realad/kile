package io.realad.kile

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * Interface for access to any storage.
 */
interface KileAdapter {

    /**
     * Return a list of contents at the specified path.
     *
     * @param path path to content.
     * @return a list of attributes if the content exists, or an empty list if the content is missing, either returns an error.
     */
    fun listContents(path: String): Either<FilesystemError, List<KileAttributes>>

    /**
     * Check if the file exists at the specified path.
     *
     * @param path the path to the file.
     * @return true if the file exists, or false if not, either return an error.
     */
    fun fileExists(path: String): Either<FilesystemError, Boolean>

}
