package is.ru.tictactoe;

import java.util.Scanner;
import java.util.Random;
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

    private int getGameType() {
        println("");
        println("What kind of game would you like?");
        println("1. Player vs Player");
        println("2. Player vs Computer");
        while (!sc.hasNext("[12]")) {
            println("Please enter 1 or 2!");
            sc.next();
        }
        return Integer.parseInt(sc.next());
    }
	   
	// Translate index to x,y coordinates
	private coordinates getCellCords(int index) {
		coordinates cord = new coordinates();
		cord.x = cordX(index);	
		cord.y = cordY(index);
		return cord;
	}

	public int cordX(int index) {
		return (index % 3);
	}

	public int cordY(int index) {
		return (index / 3);
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
		boolean human = false;

		while(!valid) { 
			// Check if player 1
			if (moves % 2 == 1) {
				print("Player " + p1.getName() + " move: ");
				human = p1.isHuman();
			} else {
				print("Player " + p2.getName() + " move: ");
				human = p2.isHuman();
			}
			
			if (human) {
    			int index = sc.nextInt();
    			coordinates cord = getCellCords(index - 1);
    			try {
    				// Need to match moves to player 1 and 2
    				game.makeMove(cord.x, cord.y, (((moves +1) % 2) + 1));
    				valid = true;
    			} catch (IllegalMoveException e) {
    				print("Try again!");
    			}
			} else {
			    Random ran= new Random();
                do {
                    print("..thinking.. ");
                    think();
                    int index = ran.nextInt(10);
                    coordinates cord = getCellCords(index - 1);
                    try {
                        game.makeMove(cord.x, cord.y, (((moves +1) % 2) + 1));
                        println("" + index);
                        valid = true;
                    } catch (IllegalMoveException e) {
                        // do nothin - just try again
                    }
                } while (!valid);
			}
		}
	}

    private void think() {
        // Fake think time
        Random ran = new Random();
        int sleep = ran.nextInt(1000);
        try {
            Thread.sleep(sleep);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
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
		int gameType = getGameType();
		p1 = setPlayer(1);
		p2 = setPlayer(2);
		if (gameType == 2)  p2.setHuman(false);
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
