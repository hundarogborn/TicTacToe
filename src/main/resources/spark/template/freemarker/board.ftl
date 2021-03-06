<!-- -*- mode: html -*- -->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TicTacToe - foo</title>
	<link rel="stylesheet" type="text/css" href="site.css" />
  </head>
  <body>
    <h1>TicTacToe</h1>
	<p>Pick a cell</p>

	<#assign playerName=playerName>
	${playerName} - make a move!

    <form method="POST" action="/" />
    <table>
    <#assign size=board.boardSize()>
    <#list 0..(size-1) as y>
      <tr>
        <#list 0..(size-1) as x>
          <#assign cell=board.getCell(x,y)>
            <#if cell == -1>
              <td><input type="submit" name="${size*y+x}" value=" "></td>
            <#else>
              <#if cell == 1>
              	<td>X</td>
              <#else>
                <td>O</td>
              </#if>
            </#if>
          </#list>
      </tr>
      </#list>
    </table>
    </form>
  </body>
</html>

