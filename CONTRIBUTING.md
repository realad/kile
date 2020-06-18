# Contributing to Kile

- Please first discuss the change you wish to make via issue with the owners of this repository before making a change.
- Read [this article](https://chris.beams.io/posts/git-commit/) before writing commit messages.
- Use `gradle build -x dokka` to build the source but exclude documentation jar generating to save time.
- `gradle detekt` should not report any errors.
- This repository follows the [Kotlin Coding Conventions](https://kotlinlang.org/docs/reference/coding-conventions.html) which are enforced by ktlint when running `gradle detekt`.
- Make sure your IDE uses [ktlint](https://github.com/pinterest/ktlint) formatting rules as well as the settings in [.editorconfig](../.editorconfig).
