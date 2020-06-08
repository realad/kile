package io.realad.kile

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

interface KileAdapter {

    fun listContents(path: String): Either<FilesystemError, List<String>>

    fun fileExists(location: String): Either<FilesystemError, Boolean>

}
