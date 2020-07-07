package io.realad.kile.adapters.local

import io.realad.kile.KileAdapter
import io.realad.kile.KileAttributes
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * An adapter for accessing the local file system.
 */
class LocalAdapter(private val fileUtils: FileUtils): KileAdapter {

    /**
     * Return a list of contents at the specified path.
     *
     * @param path path to content.
     * @return a list of attributes if the content exists, or an empty list if the content is missing, either returns an error.
     */
    override fun listContents(path: String): Either<FilesystemError, List<KileAttributes>> {
        return fileUtils.listContents(path)
    }

    /**
     * Check if the file exists at the specified path.
     *
     * @param path the path to the file.
     * @return true if the file exists, or false if not, either return an error.
     */
    override fun fileExists(path: String): Either<FilesystemError, Boolean> {
        return fileUtils.fileExists(path)
    }

}
