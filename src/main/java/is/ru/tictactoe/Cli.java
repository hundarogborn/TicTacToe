package is.ru.tictactoe;

import java.util.Scanner;
import is.ru.tictactoe.Game.GameResult;

public class Cli {

	private static Scanner sc = new Scanner(System.in);
	private Game game;
	private Player p1;
	private Player p2;
	private boolean hooked = true;


	public Cli() {
		this.game = new Game();
		this.p1 = new Player("");
		this.p2 = new Player("");
	}

	private class coordinates {
		int x;
		int y;
	}


	private void print(String string) {
		System.out.print(string);
	}
	
	private void println(String string) {
		System.out.println(string);
	}

	// changed to public
	public void printBoard() {
		char[] cell = new char[9];
		for (int index = 0; index < 9; index++) {
			coordinates cord = getCellCords(index);
			int token = game.getCell(cord.x, cord.y);
			if (token == 1)
				cell[index] = 'X';
			else if (token == 2)
				cell[index] = 'O';
			else cell[index] = ' ';
		}
		
		println("");
		String line = String.format(" %s | %s | %s    1 2 3\n", cell[0], cell[1], cell[2]);
		line += "-----------\n"; 
		line += String.format(" %s | %s | %s    4 5 6\n", cell[3], cell[4], cell[5]);
		line += "-----------\n"; 
		line += String.format(" %s | %s | %s    7 8 9\n", cell[6], cell[7], cell[8]);
		println(line);
	}

	private void greeting() {
		println("");
		String line = "\n";
		line += ".::: .::::::          .::: .::::::                 .::: .::::::                    \n";
		line += "     .::     .:            .::                          .::                        \n";
		line += "     .::          .:::     .::       .::       .:::     .::       .::       .::    \n";
		line += "     .::    .:: .::        .::     .::  .::  .::        .::     .::  .::  .:   .:: \n";
		line += "     .::    .::.::         .::    .::   .:: .::         .::    .::    .::.::::: .::\n";
		line += "     .::    .:: .::        .::    .::   .::  .::        .::     .::  .:: .:        \n";
		line += "     .::    .::   .:::     .::      .:: .:::   .:::     .::       .::      .::::   \n";
		line += "\n";
		println(line);
	}

	// Translate index to x,y coordinates
	private coordinates getCellCords(int index) {
		coordinates cord = new coordinates();
		cord.x = getCordx;	
		
	//	cord.x = (index % 3);
	//	cord.y = (index / 3);
		return cord;
	}

	public getCordx(int index) {
		return (index % 3);
	}
	

	private Player setPlayer(int num) {
		Player player;
		System.out.print("Player " + num + " name: ");
		String name = sc.next();
		player = new Player(name);
		return player;
	}

	


	private void makeMove(int moves) {
		boolean valid = false;

		while(!valid) { 
			// Check if player 1
			if (moves % 2 == 1) {
				print("Player " + p1.getName() + " move: ");
			} else {
				print("Player " + p2.getName() + " move: ");
			}
		
			int index = sc.nextInt();
			coordinates cord = getCellCords(index - 1);
			try {
				// Need to match moves to player 1 and 2
				game.makeMove(cord.x, cord.y, (((moves +1) % 2) + 1));
				valid = true;
			} catch (IllegalMoveException e) {
				print("Try again!");
			} 		
		}
	}

	private boolean playAgain() {
		println("Play again? (y/n): ");
		    while (!sc.hasNext("[yn]")) {
		    println("Please enter y or n!");
		    sc.next();
		}
		return (sc.next().equals("y"));
	}

	public void startGame() {

		greeting();
		p1 = setPlayer(1);
		p2 = setPlayer(2);
		int moves = 0;
		
		while (hooked == true) {
			do {
				printBoard();
				makeMove(++moves);
			} while (game.winner() == GameResult.GAME_IN_PROGRESS);
			
			printBoard();
			println("");
			println("");
			
			p1.addGamesPlayed();
			p2.addGamesPlayed();
			
			if (game.winner() == GameResult.PLAYER_1) {
				p1.addWin();
				println("Congratulations " + p1.name + " - You have won " + p1.getWins() + " out of " + p1.getGamesPlayed() + " games!");
			} else if (game.winner() == GameResult.PLAYER_2) {
				p2.addWin();
				println("Congratulations " + p2.name + " - You have won " + p2.getWins() + " out of " + p2.getGamesPlayed() + " games!");
			} else {
				println("To bad - this is a stale mate!");
			}
			
			// Reset game state
			game = new Game();
			moves = 0;
			
			println("");
			hooked = playAgain();
		}

		println("");
		println("Thanks for playing!");
		// Close our open IO handles
		sc.close();
	}
}
