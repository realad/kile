package io.realad.kile.adapters.ftp

import io.realad.kile.KileAttributes

interface FtpConnection {

    fun mlistDir(pathname: String): List<KileAttributes>

}
