package io.realad.kile.adapters.ftp

import io.realad.kile.KileAdapter
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either
import io.realad.kile.fp.left
import io.realad.kile.fp.right

class FtpAdapter(
    private val ftpOptions: FtpOptions,
    private val ftpProvider: FtpProvider
) : KileAdapter {

    private var connection: FtpConnection? = null
    private var connectionAttempts: Int = 3
    private var connectionAttemptsLeft: Int = connectionAttempts

    private fun connection(): Either<FilesystemError, FtpConnection> {
        var lastError: FilesystemError? = null
        while (connection == null && connectionAttemptsLeft-- > 0) {
            when (val either = ftpProvider.getConnection(ftpOptions)) {
                is Either.Left -> lastError = either.l.apply { setPrevious(lastError) }
                is Either.Right -> connection = either.r
            }
        }
        return connection?.right() ?: lastError?.left() ?: FilesystemError("undefined error").left()
    }

    override fun listContents(path: String): Either<FilesystemError, List<String>> {
        return when (val either = connection()) {
            is Either.Left -> either.l.left()
            is Either.Right -> either.r.mlistDir(path).right()
        }
    }

    override fun fileExists(location: String): Either<FilesystemError, Boolean> {
        TODO("Not yet implemented")
    }

}
