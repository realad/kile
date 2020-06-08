package io.realad.kile.adapters.ftp

interface ConnectionOptions {

    fun getHost(): String

    fun getPort(): Int

    fun getUsername(): String

    fun getPassword(): String?

}
