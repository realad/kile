package io.realad.kile

import io.realad.kile.common.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * This interface contains everything to read from and explore a filesystem.
 */
interface KileReader {

    fun listContents(path: String): Either<FilesystemError, List<String>>

    fun fileExists(location: String): Either<FilesystemError, Boolean>

}
