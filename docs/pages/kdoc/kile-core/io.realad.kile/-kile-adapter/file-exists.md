---
title: io.realad.kile.KileAdapter.fileExists - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [KileAdapter](index.html) / [fileExists](./file-exists.html)

# fileExists

(common, js, jvm) `abstract fun fileExists(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`

Check if the file exists at the specified path.

### Parameters

`path` - the path to the file.

**Return**
true if the file exists, or false if not, either return an error.

