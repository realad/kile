package io.realad.kile.fp

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Test case for the Either class.
 *
 * @see Either
 */
class EitherTest : StringSpec({

    val leftString = "left"
    val rightString = "right"

    "should turn left" {
        when (val result: Either<String, String> = leftString.left()) {
            is Either.Left -> result.l
            is Either.Right -> result.r
        } shouldBe leftString
    }

    "should turn right" {
        when (val result: Either<String, String> = rightString.right()) {
            is Either.Left -> result.l
            is Either.Right -> result.r
        } shouldBe rightString
    }

    "should return isLeft true when it is left" {
        val left = leftString.left()
        left.isLeft() shouldBe true
        left.isRight() shouldBe false
    }

    "should return isRight true when it is right" {
        val right = rightString.right()
        right.isRight() shouldBe true
        right.isLeft() shouldBe false
    }

    "should equals left creation methods" {
        Either.Left(leftString) shouldBe Either.left(leftString)
        Either.left(leftString) shouldBe leftString.left()
        leftString.left() shouldBe Either.Left.invoke(leftString)
    }

    "should equals right creation methods" {
        Either.Right(rightString) shouldBe Either.right(rightString)
        Either.right(rightString) shouldBe rightString.right()
        rightString.right() shouldBe Either.Right.invoke(rightString)
    }

})
