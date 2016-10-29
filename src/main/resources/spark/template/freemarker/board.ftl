<!-- -*- mode: html -*- -->
<html>
  <head>
    <title>TicTacToe</title>
  </head>
  <body>
    <h1>Here, be board</h1>
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
              <td>${cell}</td>
            </#if>
          </#list>
      </tr>
      </#list>
    </table>
    </form>
  </body>
</html>

