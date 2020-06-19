package io.realad.kile.adapters.ftp

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

/**
 * Test case for the FtpConnectionProvider class.
 *
 * @see FtpConnectionProvider
 */
class FtpConnectionProviderTest: StringSpec({

    "should throw not implemented error" {
        shouldThrow<NotImplementedError> {
            FtpConnectionProvider().getConnection(FtpConnectionOptions("localhost"))
        }
    }

})
