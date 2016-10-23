package tictactoe.src.main.java.is.ru.tictactoe;

public class Board {
	
	private final static int BOARD_SIZE = 3;
	private final static int MAX_PLAYERS = 2;
	private int[][] board;
	private int moves;
	
	public Board() {
		this.board = new int[BOARD_SIZE][BOARD_SIZE];
		reset();
	}
	
	private void reset() {
		this.moves = 0;
		for (int x = 0; x < BOARD_SIZE; x++) {
			for (int y = 0; y < BOARD_SIZE; y++) {
				this.board[x][y] = 0;
			}
		}
	}
	
	private void validCell(int x, int y) {
		if (0 > x || x >= BOARD_SIZE)	throw new java.lang.IndexOutOfBoundsException("Illegal move");
		if (0 > y || y >= BOARD_SIZE)	throw new java.lang.IndexOutOfBoundsException("Illegal move");		
	}
	
	private void validPlayer(int z) {
		if (z < 0 || z >= MAX_PLAYERS)	throw new java.lang.IllegalArgumentException("Illegal player");
	}
	
	public boolean resetBoard() {
		reset();
		return true;
	}

	public int getCell(int x, int y) {
		validCell(x, y);
		return board[x][y];
	}
	
	public boolean makeMove(int x, int y, int z) {
		validCell(x,y);
		validPlayer(z);
		if (board[x][y] == 0) {
			board[x][y] = z;
			return true;
		}
		return false;
	}
	
	public int winner() {
		// return 1 for player 1
		// return 2 for player 2
		// return -1 for stale mate
		// return 0 for no winner - not finished
		
		// Check horizontal and vertical
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (	board[i][0] != '0' &&
					board[i][0] == board[i][1] &&
					board[i][1] == board[i][2]) {
				return board[i][0];
			}
			if (	board[0][i] != '0' &&
					board[0][i] == board[1][i] &&
					board[1][i] == board[2][i]) {
				return board[0][i];
			}
		}
		
		// Check special cases (crosses)
		if (board[1][1] != 0) {
			if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))  return board[1][1];
			if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))  return board[1][1];
		}
		
		// If no winner is found and 9 moves have been made game is a stale mate
		if (moves > 8)	return -1;

		return 0;
	}
}
