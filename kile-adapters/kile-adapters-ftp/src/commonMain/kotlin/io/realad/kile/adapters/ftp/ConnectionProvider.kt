package io.realad.kile.adapters.ftp

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

interface ConnectionProvider<C> {

    fun getConnection(options: ConnectionOptions): Either<FilesystemError, C>

}
