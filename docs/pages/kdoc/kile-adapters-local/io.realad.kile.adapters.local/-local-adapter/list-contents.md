---
title: io.realad.kile.adapters.local.LocalAdapter.listContents - kile-adapters-local
---

[kile-adapters-local](../../index.html) / [io.realad.kile.adapters.local](../index.html) / [LocalAdapter](index.html) / [listContents](./list-contents.html)

# listContents

(common, js, jvm) `fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<KileAttributes>>`

Return a list of contents at the specified path.

### Parameters

`path` - path to content.

**Return**
a list of attributes if the content exists, or an empty list if the content is missing, either returns an error.

