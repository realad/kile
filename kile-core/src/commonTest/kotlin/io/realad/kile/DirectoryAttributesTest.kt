package io.realad.kile

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Test case for the DirectoryAttributes class.
 *
 * @see DirectoryAttributes
 */
class DirectoryAttributesTest : StringSpec({

    val testLocation = "/root/test"

    "should return the same attributes" {
        val attributes = DirectoryAttributes(testLocation)
        attributes.getType() shouldBe KileAttributes.Type.DIRECTORY
        attributes.getPath() shouldBe testLocation
    }

})
