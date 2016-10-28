<!-- -*- mode: html -*- -->
<html>
  <head>
    <title>TicTacToe</title>
  </head>
  <body>
    <h1>Here, be board</h1>
    <table>
    <#list 0..2 as y>
      <tr>
      <#list 0..2 as x>
        <td>${board.getCell(x, y)}</td>
      </#list>
      </tr>
    </#list>
    </table>
  </body>
</html>

