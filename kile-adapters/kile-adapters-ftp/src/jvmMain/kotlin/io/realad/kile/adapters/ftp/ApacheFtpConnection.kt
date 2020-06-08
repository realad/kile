package io.realad.kile.adapters.ftp

import org.apache.commons.net.ftp.FTPClient

class ApacheFtpConnection(private val client: FTPClient) : FtpConnection {

    override fun mlistDir(pathname: String): List<String> {
        return client.listFiles(pathname).map { it.name }
    }

}
