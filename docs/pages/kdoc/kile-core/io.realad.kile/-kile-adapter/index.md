---
title: io.realad.kile.KileAdapter - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [KileAdapter](./index.html)

# KileAdapter

(common, js, jvm) `interface KileAdapter`

Base interface for any file system.

### Functions

| (common, js, jvm) [fileExists](file-exists.html) | Function to check if a file exists.`abstract fun fileExists(location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| (common, js, jvm) [listContents](list-contents.html) | Function for displaying catalogs and content.`abstract fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`KileAttributes`](../-kile-attributes/index.html)`>>` |

