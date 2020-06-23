---
title: io.realad.kile.KileAttributes - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [KileAttributes](./index.html)

# KileAttributes

(common, js, jvm) `interface KileAttributes`

Interface for an entry attributes within a file system, representing a single file or directory.

### Types

| (common, js, jvm) [Type](-type/index.html) | `enum class Type` |

### Functions

| (common, js, jvm) [getPath](get-path.html) | Return the path for this file system entry`abstract fun getPath(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| (common, js, jvm) [getType](get-type.html) | Return type of this entry represents a file directory`abstract fun getType(): `[`Type`](-type/index.html) |

### Inheritors

| (common, js, jvm) [DirectoryAttributes](../-directory-attributes/index.html) | Attributes of the directory.`data class DirectoryAttributes : `[`KileAttributes`](./index.html) |
| (common, js, jvm) [FileAttributes](../-file-attributes/index.html) | Attributes of the file.`data class FileAttributes : `[`KileAttributes`](./index.html) |

