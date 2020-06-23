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

    val testHost = "localhost"
    val testPort = 1234
    val testPreviousError = FilesystemError("previous error")

    "should return message for login authentication failure" {
        val error = ConnectToFtpHostFailed.forHost(testHost, testPort)
        error.getMessage() shouldBe "Unable to connect to host $testHost at port $testPort."
        error.getPrevious() shouldBe null
    }

    "should return message for login authentication failure and previous error if exists" {
        val error = ConnectToFtpHostFailed.forHost(testHost, testPort, testPreviousError)
        error.getMessage() shouldBe "Unable to connect to host $testHost at port $testPort."
        error.getPrevious() shouldNotBe null
        error.getPrevious() shouldBe testPreviousError
        error.getPrevious()?.getMessage() shouldBe "previous error"
    }

})
