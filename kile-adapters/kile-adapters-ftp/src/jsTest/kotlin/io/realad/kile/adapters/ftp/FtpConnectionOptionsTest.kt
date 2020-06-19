package io.realad.kile.adapters.ftp

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Test case for the FtpConnectionOptions class.
 *
 * @see FtpConnectionOptions
 */
class FtpConnectionOptionsTest: StringSpec({

    "should return the same host as specified" {
        FtpConnectionOptions("localhost").getHost() shouldBe "localhost"
    }

    "should return a default port, if one is not specified" {
        FtpConnectionOptions("localhost").getPort() shouldBe 21
    }

    "should return the same port, if one is specified" {
        FtpConnectionOptions("localhost", port = 22).getPort() shouldBe 22
    }

    "should return an anonymous username, if one is not specified" {
        FtpConnectionOptions("localhost").getUsername() shouldBe "anonymous"
    }

    "should return the same username, if one is specified" {
        FtpConnectionOptions("localhost", username = "wasya").getUsername() shouldBe "wasya"
    }

    "should return a null password, if one is not specified" {
        FtpConnectionOptions("localhost").getPassword() shouldBe null
    }

    "should return the same password, if one is specified" {
        FtpConnectionOptions("localhost", password = "qwerty").getPassword() shouldBe "qwerty"
    }

})
