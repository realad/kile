package io.realad.kile.fp

sealed class Either<out L, out R> {

    internal abstract val isThisLeft: Boolean
    internal abstract val isThisRight: Boolean

    fun isLeft(): Boolean = isThisLeft

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
        fun <L> left(left: L): Either<L, Nothing> = Left(left)
        fun <R> right(right: R): Either<Nothing, R> = Right(right)
    }

}

fun <A> A.left(): Either<A, Nothing> = Either.left(this)

fun <A> A.right(): Either<Nothing, A> = Either.right(this)
