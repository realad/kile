---
title: io.realad.kile.adapters.ftp.FtpAdapter - kile-adapters-ftp
---

[kile-adapters-ftp](../../index.html) / [io.realad.kile.adapters.ftp](../index.html) / [FtpAdapter](./index.html)

# FtpAdapter

(common, js, jvm) `class FtpAdapter : KileAdapter`

An adapter for accessing the file system via FTP.

### Constructors

| (common, js, jvm) [&lt;init&gt;](-init-.html) | An adapter for accessing the file system via FTP.`<init>(ftpOptions: `[`FtpOptions`](../-ftp-options/index.html)`, ftpProvider: `[`FtpProvider`](../-ftp-provider/index.html)`)` |

### Functions

| (common, js, jvm) [fileExists](file-exists.html) | Function to check if a file exists.`fun fileExists(location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| (common, js, jvm) [listContents](list-contents.html) | Function for displaying catalogs and content.`fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<KileAttributes>>` |

