package io.realad.kile.adapters.local

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
 * Test case for the LocalAdapter class.
 *
 * @see LocalAdapter
 */
class LocalAdapterTest : StringSpec({

    val testLocation = "/root/test"
    val listOfThreeDirectoryAttributes = listOf("one", "two", "three").map { DirectoryAttributes(it) }
    val filesystemError = FilesystemError("hello error")

    lateinit var fileUtils: FileUtils
    lateinit var adapter: LocalAdapter

    beforeTest {
        fileUtils = mockk()
        adapter = LocalAdapter(fileUtils)
    }

    "should return a list of the directory contents returned from file utils" {
        every { fileUtils.listContents(any()) } returns listOfThreeDirectoryAttributes.right()
        val response = adapter.listContents(testLocation)
        response.isLeft() shouldBe false
        response.isRight() shouldBe true
        (response as Either.Right).r shouldNotBe null
        response.r shouldBe listOfThreeDirectoryAttributes
        response.r shouldContainExactly listOfThreeDirectoryAttributes
        verify(exactly = 1) { fileUtils.listContents(any()) }
        confirmVerified(fileUtils)
    }

    "should return an error after than file utils return error" {
        every { fileUtils.listContents(any()) } returns filesystemError.left()
        val response = adapter.listContents(testLocation)
        response.isLeft() shouldBe true
        response.isRight() shouldBe false
        (response as Either.Left).l shouldNotBe null
        response.l.getPrevious() shouldBe null
        verify(exactly = 1) { fileUtils.listContents(any()) }
        confirmVerified(fileUtils)
    }

    "should return a file exists result returned from file utils" {
        val fileExistsResult = true
        every { fileUtils.fileExists(any()) } returns true.right()
        val response = adapter.fileExists(testLocation)
        response.isLeft() shouldBe false
        response.isRight() shouldBe true
        (response as Either.Right).r shouldNotBe null
        response.r shouldBe fileExistsResult
        verify(exactly = 1) { fileUtils.fileExists(any()) }
        confirmVerified(fileUtils)
    }

    "should return an error after than file utils return error after calling file exists" {
        every { fileUtils.fileExists(any()) } returns filesystemError.left()
        val response = adapter.fileExists(testLocation)
        response.isLeft() shouldBe true
        response.isRight() shouldBe false
        (response as Either.Left).l shouldNotBe null
        response.l.getPrevious() shouldBe null
        verify(exactly = 1) { fileUtils.fileExists(any()) }
        confirmVerified(fileUtils)
    }


})
