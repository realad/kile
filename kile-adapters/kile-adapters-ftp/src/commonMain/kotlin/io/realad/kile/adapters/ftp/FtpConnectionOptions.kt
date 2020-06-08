package io.realad.kile.adapters.ftp

class FtpConnectionOptions(
    private val host: String,
    private val port: Int? = null,
    private val username: String? = null,
    private val password: String? = null
) : ConnectionOptions {

    override fun getHost(): String = host

    override fun getPort(): Int = port ?: 21

    override fun getUsername(): String = username ?: "anonymous"

    override fun getPassword(): String? = password

}
