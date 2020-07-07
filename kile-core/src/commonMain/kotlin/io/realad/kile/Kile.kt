package io.realad.kile

import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either

/**
 * Kile operator, which can be used to perform operations with any storage through the [adapter][KileAdapter].
 *
 * Kile performs best when you create a single `Kile` instance and reuse it for all of
 * your filesystem calls.
 *
 * An example of Local storage configuration:
 * ```kotlin
 * // The Kile instance with local storage.
 * val kile = Kile(LocalAdapter(FileUtils()))
 * val contents = kile.listContents("/")
 * ```
 *
 * An example of FTP storage configuration:
 * ```kotlin
 * // The Kile instance with FTP storage.
 * val kile = Kile(FtpAdapter(FtpConnectionOptions("ftp_host"), FtpConnectionProvider()))
 * val contents = kile.listContents("/")
 * ```
 *
 * @param adapter the storage adapter.
 * @constructor Creates a new instance.
 */
class Kile(private val adapter: KileAdapter) : KileOperator {

    /**
     * Return a list of contents at the specified path.
     *
     * @param path path to content.
     * @return a list of attributes if the content exists, or an empty list if the content is missing, either returns an error.
     */
    override fun listContents(path: String): Either<FilesystemError, List<KileAttributes>> {
        return adapter.listContents(path)
    }

    /**
     * Check if the file exists at the specified path.
     *
     * @param path the path to the file.
     * @return true if the file exists, or false if not, either return an error.
     */
    override fun fileExists(path: String): Either<FilesystemError, Boolean> {
        return adapter.fileExists(path)
    }

}
