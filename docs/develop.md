Developing TicTacToe
====================

# Required environment

All development is done in Java 1.8 (or greater) so SDK must be installed.
[Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Git is used for source control. [Download Git](https://git-scm.com/downloads) - 
[Git instructions in Icelandic](https://github.com/gaui/git)

Gradle is used for build automation. [Download Gradle](https://gradle.org/gradle-download/) - 
[Quick intro to Gradle](https://github.com/joningis/hugb_hello_world)


# Setting up the local repository

Have a member of our team grant you access to our organization and clone the repository:

```
$ git clone https://github.com/hundarogborn/TicTacToe.git

```

# Building, testing and running the application

To build the appliation and run the test suite:
```shell
$ bin/build 
```

To run the application locally:
```
$ bin/run
```

# Preparing releases

To prepare a release, simply tag master and push the tag.
Travis-CI will automatically push the release to GitHub at https://github.com/hundarogborn/TicTacToe/releases,
where it'll be available for download

```
$ git checkout <commit you want to tag>
$ git tag -a v0.0.1 -m "A fantastic release"
$ git push --tags
```

Remember to choose a sane version number and provide a meaningful message


