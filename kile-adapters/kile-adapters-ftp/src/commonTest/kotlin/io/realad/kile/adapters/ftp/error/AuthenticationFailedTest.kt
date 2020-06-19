package io.realad.kile.adapters.ftp.error

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.realad.kile.adapters.ftp.FtpConnectionOptions
import io.realad.kile.common.error.FilesystemError

/**
 * Test case for the AuthenticationFailed class.
 *
 * @see AuthenticationFailed
 */
class AuthenticationFailedTest : StringSpec({

    "should return message for login authentication failure" {
        val username = "wasya"
        val replyCode = 123
        val replyString = "authentication failure"
        val error = AuthenticationFailed.forLogin(username, replyCode, replyString)
        error.getMessage() shouldBe "Unable to login/authenticate to FTP server with username: $username," +
            " replyCode: $replyCode, replyString: $replyString"
        error.getPrevious() shouldBe null
    }

    "should return message for login authentication failure and previous error if exists" {
        val username = "wasya"
        val replyCode = 123
        val replyString = "authentication failure"
        val previousError = FilesystemError("previous error")
        val error = AuthenticationFailed.forLogin(username, replyCode, replyString, previousError)
        error.getMessage() shouldBe "Unable to login/authenticate to FTP server with username: $username," +
            " replyCode: $replyCode, replyString: $replyString"
        error.getPrevious() shouldNotBe null
        error.getPrevious()?.getMessage() shouldBe "previous error"
    }

})
