---
title: io.realad.kile.fp.Either - kile-fp
---

[kile-fp](../../index.html) / [io.realad.kile.fp](../index.html) / [Either](./index.html)

# Either

(common, js, jvm) `sealed class Either<out L, out R>`

Represents a value of one of two possible types (a disjoint union).
Instances of [Either](index.html#io.realad.kile.fp.Either) are either an instance of [Left](-left/index.html#io.realad.kile.fp.Either.Left) or [Right](-right/index.html#io.realad.kile.fp.Either.Right).
FP Convention dictates that [Left](-left/index.html#io.realad.kile.fp.Either.Left) is used for "failure"
and [Right](-right/index.html#io.realad.kile.fp.Either.Right) is used for "success".

**See Also**

[Left](-left/index.html#io.realad.kile.fp.Either.Left)

[Right](-right/index.html#io.realad.kile.fp.Either.Right)

### Types

| (common, js, jvm) [Left](-left/index.html) | The left side of the disjoint union, as opposed to the [Right](-right/index.html#io.realad.kile.fp.Either.Right) side.`data class Left<out L> : `[`Either`](./index.html)`<L, `[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| (common, js, jvm) [Right](-right/index.html) | The right side of the disjoint union, as opposed to the [Left](-left/index.html#io.realad.kile.fp.Either.Left) side.`data class Right<out R> : `[`Either`](./index.html)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`, R>` |

### Functions

| (common, js, jvm) [isLeft](is-left.html) | Returns true if this is a Left, false otherwise.`fun isLeft(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (common, js, jvm) [isRight](is-right.html) | Returns true if this is a Right, false otherwise.`fun isRight(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Companion Object Functions

| (common, js, jvm) [left](left.html) | Creates a Left type.`fun <L> left(left: L): `[`Either`](./index.html)`<L, `[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| (common, js, jvm) [right](right.html) | Creates a Left type.`fun <R> right(right: R): `[`Either`](./index.html)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`, R>` |

### Inheritors

| (common, js, jvm) [Left](-left/index.html) | The left side of the disjoint union, as opposed to the [Right](-right/index.html#io.realad.kile.fp.Either.Right) side.`data class Left<out L> : `[`Either`](./index.html)`<L, `[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| (common, js, jvm) [Right](-right/index.html) | The right side of the disjoint union, as opposed to the [Left](-left/index.html#io.realad.kile.fp.Either.Left) side.`data class Right<out R> : `[`Either`](./index.html)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`, R>` |

