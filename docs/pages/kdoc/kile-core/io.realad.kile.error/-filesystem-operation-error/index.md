---
title: io.realad.kile.error.FilesystemOperationError - kile-core
---

[kile-core](../../index.html) / [io.realad.kile.error](../index.html) / [FilesystemOperationError](./index.html)

# FilesystemOperationError

(common, js, jvm) `abstract class FilesystemOperationError : `[`FilesystemError`](../-filesystem-error/index.html)

An abstraction of errors when working with the file system.

### Types

| (common, js, jvm) [Operation](-operation/index.html) | `enum class Operation` |

### Constructors

| (common, js, jvm) [&lt;init&gt;](-init-.html) | An abstraction of errors when working with the file system.`<init>(operation: `[`Operation`](-operation/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, previous: `[`FilesystemError`](../-filesystem-error/index.html)`?)` |

### Functions

| (common, js, jvm) [getOperation](get-operation.html) | Returns an operation that was performed when an error was received`fun getOperation(): `[`Operation`](-operation/index.html) |

### Inheritors

| (common, js, jvm) [RetrieveMetadataError](../-retrieve-metadata-error/index.html) | Class for representation an error received during retrieving metadata from file or directory.`class RetrieveMetadataError : `[`FilesystemOperationError`](./index.html) |

