---
title: io.realad.kile.error.RetrieveMetadataError.fileSize - kile-core
---

[kile-core](../../index.html) / [io.realad.kile.error](../index.html) / [RetrieveMetadataError](index.html) / [fileSize](./file-size.html)

# fileSize

(common, js, jvm) `fun fileSize(location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, previous: `[`FilesystemError`](../-filesystem-error/index.html)`? = null): `[`RetrieveMetadataError`](index.html)

Returns an error instance that represents an error when the file size cannot be read

### Parameters

`location` - the location where this error retrieved

`message` - a message of the error

`previous` - a previous error, null otherwise