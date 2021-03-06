package is.ru.tictactoe;

public class Board implements java.io.Serializable {
    private final int boardSize = 3;
    private int[][] board;
    
    public Board() {
        this.board = new int[boardSize][boardSize];
        for (int cellX = 0; cellX < boardSize; cellX++) {
            for (int cellY = 0; cellY < boardSize; cellY++) {
                this.board[cellX][cellY] = -1;
            }
        }
        
        return;
    }
    
    public int boardSize() {
        return this.boardSize;
    }
    
    public int getCell(int cellX, int cellY) {
        return this.board[cellX][cellY];
    }

    // Return the cell number for coordinates, i.e., (0,0) is cell 0 and (1,0) is cell 3
    public int getCellNumber(int cellX, int cellY) {
        return cellX*this.boardSize() + cellY;
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
