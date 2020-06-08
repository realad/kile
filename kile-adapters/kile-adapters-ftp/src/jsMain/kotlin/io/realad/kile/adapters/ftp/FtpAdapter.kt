package io.realad.kile.adapters.ftp

import io.realad.kile.KileAdapter
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

class FtpAdapter(
        private val connectionOptions: ConnectionOptions,
        private val connectionProvider: ConnectionProvider<Any>
) : KileAdapter {

    override fun listContents(path: String): Either<FilesystemError, List<String>> {
        TODO("Not yet implemented")
    }

    override fun fileExists(location: String): Either<FilesystemError, Boolean> {
        TODO("Not yet implemented")
    }

}
