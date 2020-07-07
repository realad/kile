---
title: io.realad.kile.adapters.ftp.FtpAdapter.fileExists - kile-adapters-ftp
---

[kile-adapters-ftp](../../index.html) / [io.realad.kile.adapters.ftp](../index.html) / [FtpAdapter](index.html) / [fileExists](./file-exists.html)

# fileExists

(common, js, jvm) `fun fileExists(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`

Check if the file exists at the specified path.

### Parameters

`path` - the path to the file.

**Return**
true if the file exists, or false if not, either return an error.

