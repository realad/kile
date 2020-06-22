package io.realad.kile.error

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

/**
 * Test case for the FilesystemError class.
 *
 * @see FilesystemError
 */
class FilesystemErrorTest : StringSpec({

    "should return original message" {
        val error = FilesystemError("hello error")
        error.getMessage() shouldBe "hello error"
        error.getPrevious() shouldBe null
    }

    "should return previous error if exists" {
        val error = FilesystemError("hello error", FilesystemError("previous error"))
        error.getPrevious() shouldNotBe null
        error.getPrevious()?.getMessage() shouldBe "previous error"
    }

})
