package io.realad.kile.adapters.ftp

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

class FtpConnectionProvider : ConnectionProvider<Any> {

    override fun getConnection(options: ConnectionOptions): Either<FilesystemError, Any> {
        TODO("Not yet implemented")
    }

}
