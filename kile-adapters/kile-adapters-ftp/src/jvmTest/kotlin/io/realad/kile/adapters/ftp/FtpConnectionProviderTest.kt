package io.realad.kile.adapters.ftp

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec

class FtpConnectionProviderTest: StringSpec({

    "should throw not implemented error" {
        shouldNotThrowAny {
            FtpConnectionProvider().getConnection(FtpConnectionOptions("localhost"))
        }
    }

})
