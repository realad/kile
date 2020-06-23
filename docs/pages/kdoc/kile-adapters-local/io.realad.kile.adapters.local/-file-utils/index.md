---
title: io.realad.kile.adapters.local.FileUtils - kile-adapters-local
---

[kile-adapters-local](../../index.html) / [io.realad.kile.adapters.local](../index.html) / [FileUtils](./index.html)

# FileUtils

(common, js, jvm) `class FileUtils`

General file manipulation utilities.

### Constructors

| (js, jvm) [&lt;init&gt;](-init-.html) | General file manipulation utilities.`<init>()` |

### Functions

| (common, js, jvm) [fileExists](file-exists.html) | Tests whether the file or directory denoted by this abstract pathname exists.`fun fileExists(pathname: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| (common, js, jvm) [listContents](list-contents.html) | Returns an array of attributes denoting the files in the directory denoted by this abstract pathname.`fun listContents(pathname: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<KileAttributes>>` |

