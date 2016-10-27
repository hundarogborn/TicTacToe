package is.ru.tictactoe;

import java.util.Scanner;

public class Cli {

	Scanner sc = new Scanner(System.in);
	private Engine game;
	private Player p1;
	private Player p2;
	private boolean hooked = true;


	public Cli() {
		this.game = new Engine();
		this.p1 = new Player("");
		this.p2 = new Player("");
	}

	private void print(String string) {
		System.out.print(string);;
	}
	
	private void println(String string) {
		System.out.println(string);;
	}


	private void printBoard() {
		int counter = 0;
		char[] cell = new char[9];
		
		for (int i = 0; i < 9; i++) {
			int player = game.getCell(i);
			if (player == 1)
				cell[i] = 'X';
			else if (player == 2)
				cell[i] = 'O';
			else cell[i] = ' ';
		}
		
		counter = 0;
		println("");
		String line = String.format(" %s | %s | %s    1 2 3\n", cell[1], cell[2], cell[3]);
		line += "-----------\n"; 
		line += String.format(" %s | %s | %s    4 5 6\n", cell[4], cell[5], cell[6]);
		line += "-----------\n"; 
		line += String.format(" %s | %s | %s    7 8 9\n", cell[7], cell[8], cell[9]);
		println(line);
	}

}
