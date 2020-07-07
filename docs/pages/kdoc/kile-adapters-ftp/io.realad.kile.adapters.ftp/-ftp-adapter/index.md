---
title: io.realad.kile.adapters.ftp.FtpAdapter - kile-adapters-ftp
---

[kile-adapters-ftp](../../index.html) / [io.realad.kile.adapters.ftp](../index.html) / [FtpAdapter](./index.html)

# FtpAdapter

(common, js, jvm) `class FtpAdapter : KileAdapter`

An adapter for accessing the storage via FTP.

### Parameters

`ftpOptions` - the FTP connection settings.

`ftpProvider` - the FTP connection provider.

### Constructors

| (common, js, jvm) [&lt;init&gt;](-init-.html) | Creates a new instance.`<init>(ftpOptions: `[`FtpOptions`](../-ftp-options/index.html)`, ftpProvider: `[`FtpProvider`](../-ftp-provider/index.html)`)` |

### Functions

| (common, js, jvm) [fileExists](file-exists.html) | Check if the file exists at the specified path.`fun fileExists(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| (common, js, jvm) [listContents](list-contents.html) | Return a list of contents at the specified path.`fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<FilesystemError, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<KileAttributes>>` |

