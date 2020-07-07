---
title: io.realad.kile.KileAdapter - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [KileAdapter](./index.html)

# KileAdapter

(common, js, jvm) `interface KileAdapter`

Interface for access to any storage.

### Functions

| (common, js, jvm) [fileExists](file-exists.html) | Check if the file exists at the specified path.`abstract fun fileExists(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| (common, js, jvm) [listContents](list-contents.html) | Return a list of contents at the specified path.`abstract fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`KileAttributes`](../-kile-attributes/index.html)`>>` |

