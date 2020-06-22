package io.realad.kile.adapters.ftp.error

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.realad.kile.error.FilesystemError

/**
 * Test case for the ConnectToFtpHostFailed class.
 *
 * @see ConnectToFtpHostFailed
 */
class ConnectToFtpHostFailedTest : StringSpec({

    "should return message for login authentication failure" {
        val host = "localhost"
        val port = 1234
        val error = ConnectToFtpHostFailed.forHost(host, port)
        error.getMessage() shouldBe "Unable to connect to host $host at port $port."
        error.getPrevious() shouldBe null
    }

    "should return message for login authentication failure and previous error if exists" {
        val host = "localhost"
        val port = 1234
        val previousError = FilesystemError("previous error")
        val error = ConnectToFtpHostFailed.forHost(host, port, previousError)
        error.getMessage() shouldBe "Unable to connect to host $host at port $port."
        error.getPrevious() shouldNotBe null
        error.getPrevious()?.getMessage() shouldBe "previous error"
    }

})
