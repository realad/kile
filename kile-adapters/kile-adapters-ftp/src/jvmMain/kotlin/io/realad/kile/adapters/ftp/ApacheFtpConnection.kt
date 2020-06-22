package io.realad.kile.adapters.ftp

import io.realad.kile.DirectoryAttributes
import io.realad.kile.FileAttributes
import io.realad.kile.KileAttributes
import org.apache.commons.net.ftp.FTPClient

class ApacheFtpConnection(private val client: FTPClient) : FtpConnection {

    override fun mlistDir(pathname: String): List<KileAttributes> {
        return client.listFiles(pathname).map {
            if (it.isFile) {
                FileAttributes("$pathname/${it.name}", it.size)
            } else {
                DirectoryAttributes("$pathname/${it.name}")
            }
        }
    }

}
