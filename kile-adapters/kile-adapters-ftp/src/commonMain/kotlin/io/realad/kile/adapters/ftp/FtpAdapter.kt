package io.realad.kile.adapters.ftp

import io.realad.kile.KileAdapter
import io.realad.kile.KileAttributes
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either
import io.realad.kile.fp.left
import io.realad.kile.fp.right

/**
 * An adapter for accessing the file system via FTP.
 */
class FtpAdapter(
    private val ftpOptions: FtpOptions,
    private val ftpProvider: FtpProvider
) : KileAdapter {

    private var connection: Either<FilesystemError, FtpConnection> = FilesystemError("Not connected yet!").left()
    private var connectionAttempts: Int = DEFAULT_ATTEMPTS_NUMBER
    private var connectionAttemptsLeft: Int = connectionAttempts

    private fun getConnection(): Either<FilesystemError, FtpConnection> = when (connection) {
        is Either.Left -> {
            var isFirstAttempt = true
            while (connection.isLeft() && connectionAttemptsLeft-- > 0) {
                connection = reconnect(isFirstAttempt)
                isFirstAttempt = false
            }
            connectionAttemptsLeft = connectionAttempts
            connection
        }
        is Either.Right -> connection
    }

    private fun reconnect(isFirstAttempt: Boolean): Either<FilesystemError, FtpConnection> =
        when (val freshEitherConnection = ftpProvider.getConnection(ftpOptions)) {
            is Either.Left ->
                if (isFirstAttempt)
                    freshEitherConnection
                else
                    wrapError(freshEitherConnection, connection as? Either.Left)
            is Either.Right -> freshEitherConnection
        }

    private fun wrapError(
        current: Either.Left<FilesystemError>,
        previous: Either.Left<FilesystemError>?
    ): Either<FilesystemError, FtpConnection> = current.apply { l.apply { setPrevious(previous?.l) } }

    /**
     * Function for displaying catalogs and content.
     */
    override fun listContents(path: String): Either<FilesystemError, List<KileAttributes>> =
        when (val either = getConnection()) {
            is Either.Left -> either.l.left()
            is Either.Right -> either.r.mlistDir(path).right()
        }

    /**
     * Function to check if a file exists.
     */
    override fun fileExists(path: String): Either<FilesystemError, Boolean> {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DEFAULT_ATTEMPTS_NUMBER = 3
    }

}
