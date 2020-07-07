package io.realad.kile.adapters.ftp

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * Interface for the FTP connection provider.
 */
interface FtpProvider {

    /**
     * FTP connection.
     *
     * @param options FTP connection settings.
     * @return The FTP connection or error.
     */
    fun getConnection(options: FtpOptions): Either<FilesystemError, FtpConnection>

}
