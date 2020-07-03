---
title: io.realad.kile.adapters.local.FileUtils.listContents - kile-adapters-local
---

[kile-adapters-local](../../index.html) / [io.realad.kile.adapters.local](../index.html) / [FileUtils](index.html) / [listContents](./list-contents.html)

# listContents

(common, js, jvm) `fun listContents(pathname: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<KileAttributes>>`

Returns an array of attributes denoting the files in the
directory denoted by this abstract pathname.

### Parameters

`pathname` - A pathname string

**Return**
An array of attributes denoting the files and directories
in the directory denoted by the pathname. The array will be empty
if the directory is empty.

