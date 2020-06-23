---
title: io.realad.kile.error.FilesystemError - kile-core
---

[kile-core](../../index.html) / [io.realad.kile.error](../index.html) / [FilesystemError](./index.html)

# FilesystemError

(common, js, jvm) `open class FilesystemError`

Open representation of the file system error.

### Constructors

| (common, js, jvm) [&lt;init&gt;](-init-.html) | Open representation of the file system error.`<init>(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, previous: `[`FilesystemError`](./index.html)`? = null)` |

### Functions

| (common, js, jvm) [getMessage](get-message.html) | Returns a message of the error`fun getMessage(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| (common, js, jvm) [getPrevious](get-previous.html) | Returns a previous error`fun getPrevious(): `[`FilesystemError`](./index.html)`?` |
| (common, js, jvm) [setPrevious](set-previous.html) | Set a previous error`fun setPrevious(error: `[`FilesystemError`](./index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| (common, js, jvm) [FilesystemOperationError](../-filesystem-operation-error/index.html) | An abstraction of errors when working with the file system.`abstract class FilesystemOperationError : `[`FilesystemError`](./index.html) |

