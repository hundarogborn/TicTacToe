package is.ru.tictactoe;

public class Board {
	
	private final static int BOARD_SIZE = 3;
	private final static int MAX_PLAYERS = 2;
	private int[][] board;
	private int moves;
	
	public Board() {
		this.board = new int[BOARD_SIZE][BOARD_SIZE];
		reset();
	}
	
	public void reset() {
		this.moves = 0;
		for (int x = 0; x < BOARD_SIZE; x++) {
			for (int y = 0; y < BOARD_SIZE; y++) {
				this.board[x][y] = 0;
			}
		}
	}

	public enum GameResult {
		PLAYER_1,
		PLAYER_2,
		STALE_MATE,
		GAME_IN_PROGRESS,
	}
	
	private void validCell(int x, int y) {
		if (0 > x || x >= BOARD_SIZE)	throw new java.lang.IndexOutOfBoundsException("Illegal move");
		if (0 > y || y >= BOARD_SIZE)	throw new java.lang.IndexOutOfBoundsException("Illegal move");		
	}
	
	private void validPlayer(int z) {
		if (z < 0 || z >= MAX_PLAYERS)	throw new java.lang.IllegalArgumentException("Illegal player");
	}
	
	public int getCell(int x, int y) {
		validCell(x, y);
		return board[x][y];
	}
	
	public boolean makeMove(int cellX, int cellY, int player) {
		validCell(cellX, cellY);
		validPlayer(player);
		if (board[cellX][cellY] == 0) {
			board[cellX][cellY] = player;
			return true;
		}
		return false;
	}
	
	public GameResult winner() {
		int player = 0;
	
		// Check horizontal and vertical
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (	board[i][0] != '0' &&
					board[i][0] == board[i][1] &&
					board[i][1] == board[i][2]) {
				player = board[i][0];
			}
			else if (	board[0][i] != '0' &&
					board[0][i] == board[1][i] &&
					board[1][i] == board[2][i]) {
				player = board[0][i];
			}
		}
		
		// Check special cases (crosses)
		if (board[1][1] != 0) {
			if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))  player = board[1][1];
			if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))  player = board[1][1];
		}
		
		if (player == 1) 	return GameResult.PLAYER_1;
		else if (player == 2)	return GameResult.PLAYER_2;
		else if (moves > 8)	return GameResult.STALE_MATE;
		else return GameResult.GAME_IN_PROGRESS;
	}
}
