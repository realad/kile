---
title: io.realad.kile.KileReader - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [KileReader](./index.html)

# KileReader

(common, js, jvm) `interface KileReader`

This interface contains everything to read from and explore a filesystem.

### Functions

| (common, js, jvm) [fileExists](file-exists.html) | `abstract fun fileExists(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| (common, js, jvm) [listContents](list-contents.html) | Return a list of contents at the specified path.`abstract fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`KileAttributes`](../-kile-attributes/index.html)`>>` |

### Inheritors

| (common, js, jvm) [KileOperator](../-kile-operator.html) | This interface aggregates filesystem read and write interfaces.`interface KileOperator : `[`KileReader`](./index.html)`, `[`KileWriter`](../-kile-writer.html) |

