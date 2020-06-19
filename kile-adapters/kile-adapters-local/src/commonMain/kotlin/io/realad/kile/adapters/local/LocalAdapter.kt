package io.realad.kile.adapters.local

import io.realad.kile.adapters.KileAdapter
import io.realad.kile.common.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * An adapter for accessing the local file system.
 */
class LocalAdapter(private val fileUtils: FileUtils): KileAdapter {

    /**
     * Function for displaying catalogs and content.
     */
    override fun listContents(path: String): Either<FilesystemError, List<String>> {
        return fileUtils.listContents(path)
    }

    /**
     * Function to check if a file exists.
     */
    override fun fileExists(location: String): Either<FilesystemError, Boolean> {
        return fileUtils.fileExists(location)
    }

}
