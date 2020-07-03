---
title: io.realad.kile.Kile - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [Kile](./index.html)

# Kile

(common, js, jvm) `class Kile : `[`KileOperator`](../-kile-operator.html)

Kile operator, which can be used to perform operations with any storage through the [adapter](../-kile-adapter/index.html#io.realad.kile.KileAdapter).

Kile performs best when you create a single `Kile` instance and reuse it for all of
your filesystem calls.

An example of Local storage configuration:

``` kotlin
// The Kile instance with local storage.
val kile = Kile(LocalAdapter(FileUtils()))
val contents = kile.listContents("/")
```

An example of FTP storage configuration:

``` kotlin
// The Kile instance with FTP storage.
val kile = Kile(FtpAdapter(FtpConnectionOptions("ftp_host"), FtpConnectionProvider()))
val contents = kile.listContents("/")
```

### Parameters

`adapter` - the storage adapter.

### Constructors

| (common, js, jvm) [&lt;init&gt;](-init-.html) | Creates a new instance.`<init>(adapter: `[`KileAdapter`](../-kile-adapter/index.html)`)` |

### Functions

| (common, js, jvm) [fileExists](file-exists.html) | Check if the file exists at the specified path.`fun fileExists(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| (common, js, jvm) [listContents](list-contents.html) | Return a list of contents at the specified path.`fun listContents(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Either<`[`FilesystemError`](../../io.realad.kile.error/-filesystem-error/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`KileAttributes`](../-kile-attributes/index.html)`>>` |

