package io.realad.kile

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.realad.kile.fp.Either

/**
 * Test case for the DirectoryAttributes class.
 *
 * @see DirectoryAttributes
 */
class DirectoryAttributesTest : StringSpec({

    "should return the same attributes" {
        val path = "/root/test"
        val attributes = DirectoryAttributes(path)
        attributes.getType() shouldBe StorageAttributes.Type.DIRECTORY
        attributes.getPath() shouldBe path
    }

})
