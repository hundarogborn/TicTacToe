package is.ru.tictactoe;

import is.ru.tictactoe.Board;

public class HumanPlayer extends Player{
	
	public HumanPlayer(){}
	
	public HumanPlayer(String n) {
		this.name = n;
	}

	public Board playerMove(Board board, int player){
		System.out.println("Set X");
		int x = Integer.parseInt(System.console().readLine());
		System.out.println("Set Y");
		int y = Integer.parseInt(System.console().readLine());
		board.makeMove(x,y,player);
		return board;		
	}
}