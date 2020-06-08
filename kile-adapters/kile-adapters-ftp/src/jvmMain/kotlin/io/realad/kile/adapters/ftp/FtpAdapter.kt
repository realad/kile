package io.realad.kile.adapters.ftp

import io.realad.kile.fp.Either
import io.realad.kile.fp.Either.Left
import io.realad.kile.fp.Either.Right
import io.realad.kile.KileAdapter
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.left
import io.realad.kile.fp.right
import org.apache.commons.net.ftp.FTPClient

class FtpAdapter(
    private val connectionOptions: ConnectionOptions,
    private val connectionProvider: ConnectionProvider<FTPClient>
) : KileAdapter {

    private var connection: FTPClient? = null
    private var connectionAttempts: Int = 3
    private var connectionAttemptsLeft: Int = connectionAttempts

    private fun connection(): Either<FilesystemError, FTPClient> {
        return if (connection == null) {
            when (val result = connectionProvider.getConnection(connectionOptions)) {
                is Left -> {
                    if (connection == null && --connectionAttemptsLeft > 0) connection() else result
                }
                is Right -> {
                    connectionAttemptsLeft = connectionAttempts
                    connection = result.r
                    return Right(result.r)
                }
            }
        } else {
            Right(connection!!)
        }
    }

    override fun listContents(path: String): Either<FilesystemError, List<String>> {
        return when (val either = connection()) {
            is Left -> either.l.left()
            is Right -> either.r.mlistDir(path).map { it.name }.right()
        }
    }

    override fun fileExists(location: String): Either<FilesystemError, Boolean> {
        TODO("Not yet implemented")
    }

}
