package io.realad.kile.adapters.ftp

actual class FtpConnectionOptions(
    private val host: String,
    private val port: Int? = null,
    private val username: String? = null,
    private val password: String? = null
) : FtpOptions {

    override fun getHost(): String = host

    override fun getPort(): Int = port ?: DEFAULT_FTP_PORT

    override fun getUsername(): String = username ?: DEFAULT_FTP_USERNAME

    override fun getPassword(): String? = password

    companion object {
        private const val DEFAULT_FTP_PORT = 21
        private const val DEFAULT_FTP_USERNAME = "anonymous"
    }

}
