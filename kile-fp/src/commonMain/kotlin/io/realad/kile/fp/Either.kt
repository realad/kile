package io.realad.kile.fp

/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Left] or [Right].
 * FP Convention dictates that [Left] is used for "failure"
 * and [Right] is used for "success".
 *
 * @see Left
 * @see Right
 */
sealed class Either<out L, out R> {

    internal abstract val isThisLeft: Boolean
    internal abstract val isThisRight: Boolean

    /**
     * Returns true if this is a Left, false otherwise.
     * @see Left
     */
    fun isLeft(): Boolean = isThisLeft

    /**
     * Returns true if this is a Right, false otherwise.
     * @see Right
     */
    fun isRight(): Boolean = isThisRight

    /**
     * The left side of the disjoint union, as opposed to the [Right] side.
     */
    data class Left<out L> internal constructor(val l: L) : Either<L, Nothing>() {
        override val isThisLeft
            get() = true
        override val isThisRight
            get() = false

        companion object {
            operator fun <L> invoke(left: L): Either<L, Nothing> = Left(left)
        }
    }

    /**
     * The right side of the disjoint union, as opposed to the [Left] side.
     */
    data class Right<out R> internal constructor(val r: R) : Either<Nothing, R>() {
        override val isThisLeft
            get() = false
        override val isThisRight
            get() = true

        companion object {
            operator fun <R> invoke(right: R): Either<Nothing, R> = Right(right)
        }
    }

    companion object {
        /**
         * Creates a Left type.
         * @see Either.Left
         */
        fun <L> left(left: L): Either<L, Nothing> = Left(left)

        /**
         * Creates a Left type.
         * @see Either.Right
         */
        fun <R> right(right: R): Either<Nothing, R> = Right(right)
    }

}

/**
 * Creates a Left type.
 * @see Either.Left
 */
fun <A> A.left(): Either<A, Nothing> = Either.left(this)

/**
 * Creates a Left type.
 * @see Either.Right
 */
fun <A> A.right(): Either<Nothing, A> = Either.right(this)
