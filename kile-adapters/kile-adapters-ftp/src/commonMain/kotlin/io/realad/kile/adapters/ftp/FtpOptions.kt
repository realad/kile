package io.realad.kile.adapters.ftp

interface FtpOptions {

    fun getHost(): String

    fun getPort(): Int

    fun getUsername(): String

    fun getPassword(): String?

}
