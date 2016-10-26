package is.ru.tictactoe;

public class HumanPlayer extends Player{
 
 	public HumanPlayer(){}
 
 	public HumanPlayer(String n) {
  		this.name = n;
 	}
 
	public static boolean makeMove(int cellX, int cellY, Board gameboard, int player){
		return gameboard.makeMove(cellX, cellY, player);
	}
 
}