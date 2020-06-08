package io.realad.kile

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FileAttributesTest : StringSpec({

    "should return the same attributes with a null file size" {
        val path = "/root/test"
        val fileSize = null
        val attributes = FileAttributes(path, fileSize)
        attributes.getType() shouldBe StorageAttributes.Type.FILE
        attributes.getPath() shouldBe path
        attributes.getFileSize() shouldBe null
    }

    "should return the same attributes with file size" {
        val path = "/root/test"
        val fileSize = 123L
        val attributes = FileAttributes(path, fileSize)
        attributes.getType() shouldBe StorageAttributes.Type.FILE
        attributes.getPath() shouldBe path
        attributes.getFileSize() shouldBe fileSize
    }

})
