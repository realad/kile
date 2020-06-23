package io.realad.kile.adapters.ftp.error

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.realad.kile.error.FilesystemError

/**
 * Test case for the AuthenticationFailed class.
 *
 * @see AuthenticationFailed
 */
class AuthenticationFailedTest : StringSpec({

    val username = "wasya"
    val authFailureReplyCode = 123
    val authFailureReplyString = "authentication failure"
    val errorMessage = "hello error"
    val testPreviousError = FilesystemError(errorMessage)

    "should return message for login authentication failure" {
        val error = AuthenticationFailed.forLogin(username, authFailureReplyCode, authFailureReplyString)
        error.getMessage() shouldBe "Unable to login/authenticate to FTP server with username: $username," +
            " replyCode: $authFailureReplyCode, replyString: $authFailureReplyString"
        error.getPrevious() shouldBe null
    }

    "should return message for login authentication failure and previous error if exists" {
        val error = AuthenticationFailed
            .forLogin(username, authFailureReplyCode, authFailureReplyString, testPreviousError)
        error.getMessage() shouldBe "Unable to login/authenticate to FTP server with username: $username," +
            " replyCode: $authFailureReplyCode, replyString: $authFailureReplyString"
        error.getPrevious() shouldNotBe null
        error.getPrevious() shouldBe testPreviousError
        error.getPrevious()?.getMessage() shouldBe errorMessage
    }

})
