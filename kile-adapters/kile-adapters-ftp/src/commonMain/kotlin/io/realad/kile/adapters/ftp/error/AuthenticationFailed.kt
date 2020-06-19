package io.realad.kile.adapters.ftp.error

import io.realad.kile.common.error.FilesystemError

class AuthenticationFailed private constructor(
    message: String,
    previous: FilesystemError?
) : FilesystemError(message, previous) {

    companion object {
        fun forLogin(
            username: String,
            replyCode: Int,
            replyString: String,
            previous: FilesystemError? = null
        ): AuthenticationFailed {
            return AuthenticationFailed(
                "Unable to login/authenticate to FTP server with username: $username," +
                    " replyCode: $replyCode, replyString: $replyString", previous
            )
        }
    }

}
