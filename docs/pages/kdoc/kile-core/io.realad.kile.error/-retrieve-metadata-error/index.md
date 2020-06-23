---
title: io.realad.kile.error.RetrieveMetadataError - kile-core
---

[kile-core](../../index.html) / [io.realad.kile.error](../index.html) / [RetrieveMetadataError](./index.html)

# RetrieveMetadataError

(common, js, jvm) `class RetrieveMetadataError : `[`FilesystemOperationError`](../-filesystem-operation-error/index.html)

Class for representation an error received during retrieving metadata from file or directory.

### Functions

| (common, js, jvm) [getLocation](get-location.html) | Return the location where this error retrieved`fun getLocation(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| (common, js, jvm) [getMetadataType](get-metadata-type.html) | Returns the type of metadata that was attempted to be read when this error was received`fun getMetadataType(): `[`Attribute`](../../io.realad.kile/-file-attributes/-attribute/index.html) |

### Companion Object Functions

| (common, js, jvm) [fileSize](file-size.html) | Returns an error instance that represents an error when the file size cannot be read`fun fileSize(location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, previous: `[`FilesystemError`](../-filesystem-error/index.html)`? = null): `[`RetrieveMetadataError`](./index.html) |

