package is.ru.tictactoe;

public class Board {
    private final int boardSize;
	private int[][] board;
	
	public Board(int boardSize) {
		this.board = new int[boardSize][boardSize];
        this.boardSize = boardSize;
		for (int cellX = 0; cellX < boardSize; cellX++) {
			for (int cellY = 0; cellY < boardSize; cellY++) {
				this.board[cellX][cellY] = -1;
			}
		}
        
        return;
	}
    
    public int boardSize() {
        return boardSize;
    }
    
    public int getCell(int cellX, int cellY) {
		return board[cellX][cellY];
	}

    /* setCellOnce - Set (cellX, cellY) to value if-and-only-if it hasn't been set before.
     * If the cell has already been set, throw IllegalStateException
     */
    public void setCellOnce(int cellX, int cellY, int playerId) {
        if(this.getCell(cellX, cellY) < 0) {
            board[cellX][cellY] = playerId;
        } else {
            throw new IllegalStateException("cell has already been set");
        }
    }
}
