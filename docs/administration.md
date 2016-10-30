Administering TicTacToe
=======================

Some of the details here overlap with the develop documentation, so you might want to take
a look at that as well.

# Prerequisites

We use Java 8 features, so ensure that you have Java 8 runtime installed.
You can find it here: http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html

# Releases

Our releases can be found on [our GitHub releases page](https://github.com/hundarogborn/TicTacToe/releases).

Each release is simply an "uberjar", a self-contained JAR for minimal overhead, so you do not need to install
any dependencies.

# Running

TicTacToe can be run in two ways:

- As a command line application where you interactively play

- As a web application

Download an uberjar from [our GitHub releases page](https://github.com/hundarogborn/TicTacToe/releases) and:

## Running the CLI app

```
$ java -jar path/to/tictactoe.jar cli
```

## Running the Web app

```
$ java -jar path/to/tictactoe.jar web
```

By default, the application listens on tcp/4567.

To have it listen on something else, export the PORT environment variable:
```
$ export PORT=1234 
$ java -jar path/to/tictactoe.jar web
```

# Development and staging environments

We utilize a few different services for our app, each with it's own access control etc.
Here's a list of people that can grant access to each.


## GitHub

All members of our team are organization owners, so feel free to approach anyone.

## Heroku

@sveinng has the credentials for Heroku

## Travis

All github org owners can access and administer our travis-ci account.

## CodeCov.io

@sveinng has the credentials for CodeCov.

