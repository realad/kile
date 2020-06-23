---
title: io.realad.kile.Kile - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [Kile](./index.html)

# Kile

(common, js, jvm) `class Kile : `[`KileOperator`](../-kile-operator.html)

This is core class to access to the kile functionality

### Constructors

| (common, js, jvm) [&lt;init&gt;](-init-.html) | This is core class to access to the kile functionality`<init>(adapter: `[`KileAdapter`](../-kile-adapter/index.html)`)` |

### Functions

| (common, js, jvm) [fileExists](file-exists.html) | Function to check if a file exists.`fun fileExists(location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| (common, js, jvm) [listContents](list-contents.html) | Function for displaying catalogs and content.`fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`KileAttributes`](../-kile-attributes/index.html)`>>` |

