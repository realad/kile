---
title: io.realad.kile.FileAttributes - kile-core
---

[kile-core](../../index.html) / [io.realad.kile](../index.html) / [FileAttributes](./index.html)

# FileAttributes

(common, js, jvm) `data class FileAttributes : `[`KileAttributes`](../-kile-attributes/index.html)

Attributes of the file.

### Types

| (common, js, jvm) [Attribute](-attribute/index.html) | `enum class Attribute` |

### Constructors

| (common, js, jvm) [&lt;init&gt;](-init-.html) | Attributes of the file.`<init>(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, fileSize: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?)` |

### Functions

| (common, js, jvm) [getFileSize](get-file-size.html) | `fun getFileSize(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?` |
| (common, js, jvm) [getPath](get-path.html) | Return the path for this file system entry`fun getPath(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| (common, js, jvm) [getType](get-type.html) | Return type of this entry represents a file directory`fun getType(): `[`Type`](../-kile-attributes/-type/index.html) |

