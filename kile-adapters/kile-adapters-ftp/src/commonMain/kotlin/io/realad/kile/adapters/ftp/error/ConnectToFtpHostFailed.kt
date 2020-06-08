package io.realad.kile.adapters.ftp.error

import io.realad.kile.error.FilesystemError

class ConnectToFtpHostFailed(
    message: String,
    previous: FilesystemError? = null
) : FilesystemError(message, previous) {

    companion object {
        fun forHost(host: String, port: Int, previous: FilesystemError? = null): ConnectToFtpHostFailed {
            return ConnectToFtpHostFailed("Unable to connect to host $host at port $port.", previous)
        }
    }

}
