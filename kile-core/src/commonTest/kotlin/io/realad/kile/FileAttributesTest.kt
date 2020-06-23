package io.realad.kile

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Test case for the FileAttributes class.
 *
 * @see FileAttributes
 */
class FileAttributesTest : StringSpec({

    val testLocation = "/root/test"

    "should return the same attributes with a null file size" {
        val fileSize = null
        val attributes = FileAttributes(testLocation, fileSize)
        attributes.getType() shouldBe KileAttributes.Type.FILE
        attributes.getPath() shouldBe testLocation
        attributes.getFileSize() shouldBe null
    }

    "should return the same attributes with file size" {
        val fileSize = 123L
        val attributes = FileAttributes(testLocation, fileSize)
        attributes.getType() shouldBe KileAttributes.Type.FILE
        attributes.getPath() shouldBe testLocation
        attributes.getFileSize() shouldBe fileSize
    }

})
