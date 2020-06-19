package io.realad.kile.adapters.local

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.realad.kile.common.error.FilesystemError
import io.realad.kile.fp.Either
import io.realad.kile.fp.left
import io.realad.kile.fp.right

/**
 * Test case for the LocalAdapter class.
 *
 * @see LocalAdapter
 */
class LocalAdapterTest : StringSpec({

    lateinit var fileUtils: FileUtils
    lateinit var adapter: LocalAdapter

    beforeTest {
        fileUtils = mockk()
        adapter = LocalAdapter(fileUtils)
    }

    "should return a list of the directory contents returned from file utils" {
        val location = "/root/test"
        val listDirectoryResult = listOf("one", "two", "three")
        every { fileUtils.listContents(any()) } returns listDirectoryResult.right()
        val response = adapter.listContents(location)
        response.isLeft() shouldBe false
        response.isRight() shouldBe true
        (response as Either.Right).r shouldNotBe null
        response.r shouldBe listDirectoryResult
        response.r shouldContainExactly listDirectoryResult
        verify(exactly = 1) { fileUtils.listContents(any()) }
        confirmVerified(fileUtils)
    }

    "should return an error after than file utils return error" {
        val location = "/root/test"
        every { fileUtils.listContents(any()) } returns FilesystemError("hello error").left()
        val response = adapter.listContents(location)
        response.isLeft() shouldBe true
        response.isRight() shouldBe false
        (response as Either.Left).l shouldNotBe null
        response.l.getPrevious() shouldBe null
        verify(exactly = 1) { fileUtils.listContents(any()) }
        confirmVerified(fileUtils)
    }

    "should return a file exists result returned from file utils" {
        val location = "/root/test"
        val fileExistsResult = true
        every { fileUtils.fileExists(any()) } returns true.right()
        val response = adapter.fileExists(location)
        response.isLeft() shouldBe false
        response.isRight() shouldBe true
        (response as Either.Right).r shouldNotBe null
        response.r shouldBe fileExistsResult
        verify(exactly = 1) { fileUtils.fileExists(any()) }
        confirmVerified(fileUtils)
    }

    "should return an error after than file utils return error after calling file exists" {
        val location = "/root/test"
        every { fileUtils.fileExists(any()) } returns FilesystemError("hello error").left()
        val response = adapter.fileExists(location)
        response.isLeft() shouldBe true
        response.isRight() shouldBe false
        (response as Either.Left).l shouldNotBe null
        response.l.getPrevious() shouldBe null
        verify(exactly = 1) { fileUtils.fileExists(any()) }
        confirmVerified(fileUtils)
    }


})
