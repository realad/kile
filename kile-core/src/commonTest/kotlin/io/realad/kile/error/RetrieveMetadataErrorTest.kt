package io.realad.kile.error

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.realad.kile.FileAttributes
import io.realad.kile.common.error.FilesystemError

class RetrieveMetadataErrorTest : StringSpec({

    "should return original data" {
        val error = RetrieveMetadataError.fileSize("/root/test", "hello error")
        error.getLocation() shouldBe "/root/test"
        error.getMetadataType() shouldBe FileAttributes.Attribute.FILE_SIZE
        error.getOperation() shouldBe FilesystemOperationError.Operation.RETRIEVE_METADATA
        error.getMessage() shouldBe "hello error"
        error.getPrevious() shouldBe null
    }

    "should return original data with previous error data" {
        val previousError = FilesystemError("hello error")
        val error = RetrieveMetadataError.fileSize("/root/test", "hello error", previousError)
        error.getLocation() shouldBe "/root/test"
        error.getMetadataType() shouldBe FileAttributes.Attribute.FILE_SIZE
        error.getOperation() shouldBe FilesystemOperationError.Operation.RETRIEVE_METADATA
        error.getMessage() shouldBe "hello error"
        error.getPrevious() shouldNotBe  null
        error.getPrevious()?.getMessage() shouldBe "hello error"
    }

})
