Developing TicTacToe
====================

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


