package io.realad.kile.adapters.ftp

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.every
import io.mockk.mockkConstructor
import io.realad.kile.adapters.ftp.error.AuthenticationFailed
import io.realad.kile.adapters.ftp.error.ConnectToFtpHostFailed
import io.realad.kile.fp.Either
import org.apache.commons.net.ftp.FTPClient
import java.io.IOException

/**
 * Test case for the FtpConnectionProvider class.
 *
 * @see FtpConnectionProvider
 */
class FtpConnectionProviderTest : StringSpec({

    val ftpConnectionOptions = FtpConnectionOptions("localhost")

    beforeTest {
        mockkConstructor(FTPClient::class)
    }

    "should return the connection if everything went well" {
        every { anyConstructed<FTPClient>().connect(any<String>(), any()) } returns Unit
        every { anyConstructed<FTPClient>().replyCode } returns 200
        every { anyConstructed<FTPClient>().login(any(), any()) } returns true
        val either = FtpConnectionProvider().getConnection(ftpConnectionOptions)
        either.isLeft() shouldBe false
        either.isRight() shouldBe true
        (either as Either.Right).r shouldNotBe null
        either.r.shouldBeTypeOf<ApacheFtpConnection>()
    }

    "should return the connect to ftp host failed if connect returns an io exception" {
        every { anyConstructed<FTPClient>().connect(any<String>(), any()) } throws IOException("hello exception")
        val either = FtpConnectionProvider().getConnection(ftpConnectionOptions)
        either.isLeft() shouldBe true
        either.isRight() shouldBe false
        (either as Either.Left).l shouldNotBe null
        either.l.shouldBeTypeOf<ConnectToFtpHostFailed>()
    }

    "should return the connect to ftp host failed if connect returns a not positive response code" {
        every { anyConstructed<FTPClient>().connect(any<String>(), any()) } returns Unit
        every { anyConstructed<FTPClient>().replyCode } returns 301
        val either = FtpConnectionProvider().getConnection(ftpConnectionOptions)
        either.isLeft() shouldBe true
        either.isRight() shouldBe false
        (either as Either.Left).l shouldNotBe null
        either.l.shouldBeTypeOf<ConnectToFtpHostFailed>()
    }

    "should return the authentication failed if login returns false" {
        every { anyConstructed<FTPClient>().connect(any<String>(), any()) } returns Unit
        every { anyConstructed<FTPClient>().replyCode } returns 200
        every { anyConstructed<FTPClient>().replyString } returns "everything is fine"
        every { anyConstructed<FTPClient>().login(any(), any()) } returns false
        val either = FtpConnectionProvider().getConnection(ftpConnectionOptions)
        either.isLeft() shouldBe true
        either.isRight() shouldBe false
        (either as Either.Left).l shouldNotBe null
        either.l.shouldBeTypeOf<AuthenticationFailed>()
    }

    "should return the authentication failed if login returns an io exception" {
        every { anyConstructed<FTPClient>().connect(any<String>(), any()) } returns Unit
        every { anyConstructed<FTPClient>().replyCode } returns 200 andThen 301
        every { anyConstructed<FTPClient>().replyString } returns "everything is fine" andThen "something went wrong"
        every { anyConstructed<FTPClient>().login(any(), any()) } throws IOException("hello exception")
        val either = FtpConnectionProvider().getConnection(ftpConnectionOptions)
        either.isLeft() shouldBe true
        either.isRight() shouldBe false
        (either as Either.Left).l shouldNotBe null
        either.l.shouldBeTypeOf<ConnectToFtpHostFailed>()
    }

})
