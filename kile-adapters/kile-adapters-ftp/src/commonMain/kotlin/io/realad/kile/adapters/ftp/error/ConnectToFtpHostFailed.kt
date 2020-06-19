package io.realad.kile.adapters.ftp.error

import io.realad.kile.common.error.FilesystemError

class ConnectToFtpHostFailed private constructor(
    message: String,
    previous: FilesystemError?
) : FilesystemError(message, previous) {

    companion object {
        fun forHost(host: String, port: Int, previous: FilesystemError? = null): ConnectToFtpHostFailed {
            return ConnectToFtpHostFailed("Unable to connect to host $host at port $port.", previous)
        }
    }

}
