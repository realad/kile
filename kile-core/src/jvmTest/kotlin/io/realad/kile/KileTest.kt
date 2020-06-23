package io.realad.kile

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.realad.kile.fp.right

/**
 * Test case for the Kile class.
 *
 * @see Kile
 */
class KileTest : StringSpec({

    val testLocation = "/root/test"
    val listOfThreeDirectoryAttributes = listOf("one", "two", "three").map { DirectoryAttributes(it) }

    lateinit var adapter: KileAdapter
    lateinit var kile: Kile

    beforeTest {
        adapter = mockk()
        kile = Kile(adapter)
    }

    "fileExists should return true if the adapter returns true" {
        every { adapter.fileExists(testLocation) } returns true.right()
        kile.fileExists(testLocation) shouldBe true.right()
        verify(exactly = 1) { adapter.fileExists(testLocation) }
        confirmVerified(adapter)
    }

    "fileExists should return false if the adapter returns false" {
        every { adapter.fileExists(testLocation) } returns false.right()
        kile.fileExists(testLocation) shouldBe false.right()
        verify(exactly = 1) { adapter.fileExists(testLocation) }
        confirmVerified(adapter)
    }

    "listContent should return list if the adapter returns list" {
        every { adapter.listContents(testLocation) } returns listOfThreeDirectoryAttributes.right()
        kile.listContents(testLocation) shouldBe listOfThreeDirectoryAttributes.right()
        verify(exactly = 1) { adapter.listContents(testLocation) }
        confirmVerified(adapter)
    }

})
