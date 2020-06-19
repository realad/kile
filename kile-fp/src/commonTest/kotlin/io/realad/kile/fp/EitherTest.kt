package io.realad.kile.fp

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Test case for the Either class.
 *
 * @see Either
 */
class EitherTest : StringSpec({

    "should turn left" {
        when (val result: Either<String, String> = "left".left()) {
            is Either.Left -> result.l
            is Either.Right -> result.r
        } shouldBe "left"
    }

    "should turn right" {
        when (val result: Either<String, String> = "right".right()) {
            is Either.Left -> result.l
            is Either.Right -> result.r
        } shouldBe "right"
    }

    "should return isLeft true when it is left" {
        val left = "left".left()
        left.isLeft() shouldBe true
        left.isRight() shouldBe false
    }

    "should return isRight true when it is right" {
        val right = "right".right()
        right.isRight() shouldBe true
        right.isLeft() shouldBe false
    }

    "should equals left creation methods" {
        Either.Left("left") shouldBe Either.left("left")
        Either.left("left") shouldBe "left".left()
        "left".left() shouldBe Either.Left.invoke("left")
    }

    "should equals right creation methods" {
        Either.Right("right") shouldBe Either.right("right")
        Either.right("right") shouldBe "right".right()
        "right".right() shouldBe Either.Right.invoke("right")
    }

})
