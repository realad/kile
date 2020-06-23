package io.realad.kile.adapters.ftp

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Test case for the FtpConnectionOptions class.
 *
 * @see FtpConnectionOptions
 */
class FtpConnectionOptionsTest: StringSpec({

    val testHost = "localhost"
    val testPortFtp = 21
    val testPortSftp = 22
    val testAnonymous = "anonymous"
    val testUsername = "wasya"
    val testPassword = "qwerty"

    "should return the same host as specified" {
        FtpConnectionOptions(testHost).getHost() shouldBe testHost
    }

    "should return a default port, if one is not specified" {
        FtpConnectionOptions(testHost).getPort() shouldBe testPortFtp
    }

    "should return the same port, if one is specified" {
        FtpConnectionOptions(testHost, port = testPortSftp).getPort() shouldBe testPortSftp
    }

    "should return an anonymous username, if one is not specified" {
        FtpConnectionOptions(testHost).getUsername() shouldBe testAnonymous
    }

    "should return the same username, if one is specified" {
        FtpConnectionOptions(testHost, username = testUsername).getUsername() shouldBe testUsername
    }

    "should return a null password, if one is not specified" {
        FtpConnectionOptions(testHost).getPassword() shouldBe null
    }

    "should return the same password, if one is specified" {
        FtpConnectionOptions(testHost, password = testPassword).getPassword() shouldBe testPassword
    }

})
