package io.realad.kile.adapters.ftp

/**
 * Interface for the FTP connection settings.
 */
interface FtpOptions {

    /**
     * FTP host.
     *
     * @return the FTP host.
     */
    fun getHost(): String

    /**
     * FTP port.
     *
     * @return the FTP port.
     */
    fun getPort(): Int

    /**
     * FTP username.
     *
     * @return the FTP username.
     */
    fun getUsername(): String

    /**
     * FTP user password.
     *
     * @return the FTP user password or null.
     */
    fun getPassword(): String?

}
