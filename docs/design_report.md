Tic-Tac-Toe design report
=========================

Tic-Tac-Toe is a web application that allows a player to play
Tic-Tac-Toe against a computer opponent.

The application is composed of three major components:

- The presentation layer

- The Tic-Tac-Toe game engine

- High-score persistence layer

All of them run within the same process; we do no RPC calls.

# Presentation layer

The presentation layer is responsible for exposing the UI via HTTP.
It's implemented using Spark and stores as little state as possible.
It utilizes the Tic-Tac-Toe engine to do gameplay and
the high-score persistence layer to view and save high-scores.

# The Game Engine

The game engine is a library that allows playing of Tic-Tac-Toe.
An UML diagram of the engine is attached.

# High-score persistence layer

Responsible for storing and displaying player high-scores.
It utilizes a SQLite database, accessed using the Xerial library.



