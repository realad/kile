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

    lateinit var adapter: KileAdapter
    lateinit var kile: Kile

    beforeTest {
        adapter = mockk()
        kile = Kile(adapter)
    }

    "fileExists should return true if the adapter returns true" {
        val location = "/root/test"
        every { adapter.fileExists(location) } returns true.right()
        kile.fileExists(location) shouldBe true.right()
        verify(exactly = 1) { adapter.fileExists(location) }
        confirmVerified(adapter)
    }

    "fileExists should return false if the adapter returns false" {
        val location = "/root/test"
        every { adapter.fileExists(location) } returns false.right()
        kile.fileExists(location) shouldBe false.right()
        verify(exactly = 1) { adapter.fileExists(location) }
        confirmVerified(adapter)
    }

    "listContent should return list if the adapter returns list" {
        val location = "/root/test"
        val list = listOf("one", "two", "three").map { DirectoryAttributes(it) }
        every { adapter.listContents(location) } returns list.right()
        kile.listContents(location) shouldBe list.right()
        verify(exactly = 1) { adapter.listContents(location) }
        confirmVerified(adapter)
    }

})
