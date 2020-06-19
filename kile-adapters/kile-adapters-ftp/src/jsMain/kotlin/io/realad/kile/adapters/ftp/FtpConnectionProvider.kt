package io.realad.kile.adapters.ftp

import io.realad.kile.common.error.FilesystemError
import io.realad.kile.fp.Either

actual class FtpConnectionProvider : FtpProvider {

    override fun getConnection(options: FtpOptions): Either<FilesystemError, FtpConnection> {
        TODO("Not yet implemented")
    }

}
