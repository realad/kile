---
title: io.realad.kile.fp - kile-fp
---

[kile-fp](../index.html) / [io.realad.kile.fp](./index.html)

## Package io.realad.kile.fp

### Types

| (common, js, jvm) [Either](-either/index.html) | Represents a value of one of two possible types (a disjoint union). Instances of [Either](-either/index.html#io.realad.kile.fp.Either) are either an instance of [Left](-either/-left/index.html#io.realad.kile.fp.Either.Left) or [Right](-either/-right/index.html#io.realad.kile.fp.Either.Right). FP Convention dictates that [Left](-either/-left/index.html#io.realad.kile.fp.Either.Left) is used for "failure" and [Right](-either/-right/index.html#io.realad.kile.fp.Either.Right) is used for "success".`sealed class Either<out L, out R>` |

### Functions

| (common, js, jvm) [left](left.html) | Creates a Left type.`fun <A> A.left(): `[`Either`](-either/index.html)`<A, `[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>` |
| (common, js, jvm) [right](right.html) | Creates a Left type.`fun <A> A.right(): `[`Either`](-either/index.html)`<`[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`, A>` |

