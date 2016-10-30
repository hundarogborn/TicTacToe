<!-- -*- mode: html -*- -->
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TicTacToe</title>
	<link rel="stylesheet" type="text/css" href="site.css" />
  <body>
  
    <h1>Tic Tac Toe</h1>
	
    <form action="/entry" method="POST">
      Player 1 name:<br>
      <input type="text" name="player1"/><br>
      Player 2 name:<br>
      <input type="text" name="player2"/><br>
      Game type:<br>
      <input type="radio" name="type" value="pvp" checked> Player vs Player<br>
      <input type="radio" name="type" value="pvc"> Player vs Computer<br>
      <input type="submit"/>
    </form>

  </body>
  </head>
</html>
