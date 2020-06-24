---
title: io.realad.kile - kile-core
---

[kile-core](../index.html) / [io.realad.kile](./index.html)

## Package io.realad.kile

### Types

| (common, js, jvm) [DirectoryAttributes](-directory-attributes/index.html) | Attributes of the directory.`data class DirectoryAttributes : `[`KileAttributes`](-kile-attributes/index.html) |
| (common, js, jvm) [FileAttributes](-file-attributes/index.html) | Attributes of the file.`data class FileAttributes : `[`KileAttributes`](-kile-attributes/index.html) |
| (common, js, jvm) [Kile](-kile/index.html) | This is core class to access to the kile functionality`class Kile : `[`KileOperator`](-kile-operator.html) |
| (common, js, jvm) [KileAdapter](-kile-adapter/index.html) | Base interface for any file system.`interface KileAdapter` |
| (common, js, jvm) [KileAttributes](-kile-attributes/index.html) | Interface for an entry attributes within a file system, representing a single file or directory.`interface KileAttributes` |
| (common, js, jvm) [KileOperator](-kile-operator.html) | This interface aggregates filesystem read and write interfaces.`interface KileOperator : `[`KileReader`](-kile-reader/index.html)`, `[`KileWriter`](-kile-writer.html) |
| (common, js, jvm) [KileReader](-kile-reader/index.html) | This interface contains everything to read from and explore a filesystem.`interface KileReader` |
| (common, js, jvm) [KileWriter](-kile-writer.html) | This interface contains everything to write to and edit a filesystem.`interface KileWriter` |
