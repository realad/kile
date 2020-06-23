package io.realad.kile.adapters.ftp

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.realad.kile.DirectoryAttributes
import io.realad.kile.error.FilesystemError
import io.realad.kile.fp.Either
import io.realad.kile.fp.left
import io.realad.kile.fp.right

/**
 * Test case for the FtpAdapter class.
 *
 * @see FtpAdapter
 */
class FtpAdapterTest : StringSpec({

    val testLocation = "/root/test"
    val listOfThreeDirectoryAttributes = listOf("one", "two", "three").map { DirectoryAttributes(it) }
    val errorMessage = "hello error"

    lateinit var options: FtpOptions
    lateinit var provider: FtpProvider
    lateinit var connection: FtpConnection
    lateinit var adapter: FtpAdapter

    beforeTest {
        options = mockk()
        provider = mockk()
        connection = mockk()
        adapter = FtpAdapter(options, provider)
    }

    "should return a list of the directory contents returned from connection without reconnection" {
        every { provider.getConnection(any()) } returns connection.right()
        every { connection.mlistDir(any()) } returns listOfThreeDirectoryAttributes
        val response = adapter.listContents(testLocation)
        response.isLeft() shouldBe false
        response.isRight() shouldBe true
        (response as Either.Right).r shouldNotBe null
        response.r shouldBe listOfThreeDirectoryAttributes
        response.r shouldContainExactly listOfThreeDirectoryAttributes
        verify(exactly = 1) { provider.getConnection(any()) }
        verify(exactly = 1) { connection.mlistDir(any()) }
        confirmVerified(connection, provider)
    }

    "should return a list of the directory contents returned from connection with a single reconnection" {
        every { provider.getConnection(any()) } returns FilesystemError(errorMessage).left() andThen connection.right()
        every { connection.mlistDir(any()) } returns listOfThreeDirectoryAttributes
        val response = adapter.listContents(testLocation)
        response.isLeft() shouldBe false
        response.isRight() shouldBe true
        (response as Either.Right).r shouldNotBe null
        response.r shouldBe listOfThreeDirectoryAttributes
        response.r shouldContainExactly listOfThreeDirectoryAttributes
        verify(exactly = 2) { provider.getConnection(any()) }
        verify(exactly = 1) { connection.mlistDir(any()) }
        confirmVerified(connection, provider)
    }

    "should return a list of the directory contents returned from connection with a triple reconnection" {
        every { provider.getConnection(any()) } returns FilesystemError(errorMessage).left() andThen
            FilesystemError(errorMessage).left() andThen connection.right()
        every { connection.mlistDir(any()) } returns listOfThreeDirectoryAttributes
        val response = adapter.listContents(testLocation)
        response.isLeft() shouldBe false
        response.isRight() shouldBe true
        (response as Either.Right).r shouldNotBe null
        response.r shouldBe listOfThreeDirectoryAttributes
        response.r shouldContainExactly listOfThreeDirectoryAttributes
        verify(exactly = 3) { provider.getConnection(any()) }
        verify(exactly = 1) { connection.mlistDir(any()) }
        confirmVerified(connection, provider)
    }

    "should return an error after more than three reconnections" {
        every { provider.getConnection(any()) } returns FilesystemError(errorMessage).left() andThen
            FilesystemError(errorMessage).left() andThen FilesystemError(errorMessage).left()
        every { connection.mlistDir(any()) } returns listOfThreeDirectoryAttributes
        val response = adapter.listContents(testLocation)
        response.isLeft() shouldBe true
        response.isRight() shouldBe false
        (response as Either.Left).l shouldNotBe null
        response.l.getPrevious() shouldNotBe null
        response.l.getPrevious()?.getPrevious() shouldNotBe null
        response.l.getPrevious()?.getPrevious()?.getPrevious() shouldBe null
        verify(exactly = 3) { provider.getConnection(any()) }
        verify(exactly = 0) { connection.mlistDir(any()) }
        confirmVerified(connection, provider)
    }

    "should return a list of directory contents with a single reconnection and then return the list successfully" {
        every { provider.getConnection(any()) } returns FilesystemError(errorMessage).left() andThen connection.right()
        every { connection.mlistDir(any()) } returns listOfThreeDirectoryAttributes
        val firstResponse = adapter.listContents(testLocation)
        firstResponse.isLeft() shouldBe false
        firstResponse.isRight() shouldBe true
        (firstResponse as Either.Right).r shouldNotBe null
        firstResponse.r shouldBe listOfThreeDirectoryAttributes
        firstResponse.r shouldContainExactly listOfThreeDirectoryAttributes
        val secondResponse = adapter.listContents(testLocation)
        secondResponse.isLeft() shouldBe false
        secondResponse.isRight() shouldBe true
        (secondResponse as Either.Right).r shouldNotBe null
        secondResponse.r shouldBe listOfThreeDirectoryAttributes
        secondResponse.r shouldContainExactly listOfThreeDirectoryAttributes
        verify(exactly = 2) { provider.getConnection(any()) }
        verify(exactly = 2) { connection.mlistDir(any()) }
        confirmVerified(connection, provider)
    }

})
