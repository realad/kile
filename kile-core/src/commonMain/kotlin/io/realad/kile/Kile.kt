package io.realad.kile

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

class Kile(private val adapter: KileAdapter) : KileOperator {

    override fun listContents(path: String): Either<FilesystemError, List<String>> {
        return adapter.listContents(path)
    }

    override fun fileExists(location: String): Either<FilesystemError, Boolean> {
        return adapter.fileExists(location)
    }

}
