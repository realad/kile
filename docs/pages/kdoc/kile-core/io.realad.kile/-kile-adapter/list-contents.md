---
title: io.realad.kile.KileAdapter.listContents - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [KileAdapter](index.html) / [listContents](./list-contents.html)

# listContents

(common, js, jvm) `abstract fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`KileAttributes`](../-kile-attributes/index.html)`>>`

Return a list of contents at the specified path.

### Parameters

`path` - path to content.

**Return**
a list of attributes if the content exists, or an empty list if the content is missing, either returns an error.

