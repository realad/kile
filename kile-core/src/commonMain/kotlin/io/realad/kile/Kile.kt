package io.realad.kile

import io.realad.kile.adapters.KileAdapter
import io.realad.kile.common.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * This is core class to access to the kile functionality
 */
class Kile(private val adapter: KileAdapter) : KileOperator {

    /**
     * Function for displaying catalogs and content.
     */
    override fun listContents(path: String): Either<FilesystemError, List<String>> {
        return adapter.listContents(path)
    }

    /**
     * Function to check if a file exists.
     */
    override fun fileExists(location: String): Either<FilesystemError, Boolean> {
        return adapter.fileExists(location)
    }

}
