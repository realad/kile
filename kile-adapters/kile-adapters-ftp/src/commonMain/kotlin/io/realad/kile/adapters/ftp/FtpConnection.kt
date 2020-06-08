package io.realad.kile.adapters.ftp

interface FtpConnection {

    fun mlistDir(pathname: String): List<String>

}
