package is.ru.tictactoe;

public class Game {

    private final static int MAX_PLAYERS = 2;
    private Board board;
    private int moves = 0;
    
    public enum GameResult {
        PLAYER_1,
        PLAYER_2,
        STALE_MATE,
        GAME_IN_PROGRESS,
    }
    
    public Game() {
        this(new Board());
    }

    public Game(Board b) {
        this.board = b;
    }

    public final Board getBoard() {
        return this.board;
    }

    public final int getMoves() {
        return moves;
    }

    /* makeMove - Mark cell (X, Y) as played by player.
     * If cell has already been played or if cell index is out of bounds; throw IllegalMoveException.
     */
    public void makeMove(int cellX, int cellY, int playerId) throws IllegalMoveException {
        try {
            validatePlayer(playerId);
            this.board.setCellOnce(cellX, cellY, playerId);
            this.moves++;
        } catch(IndexOutOfBoundsException e) {
            throw new IllegalMoveException("move is out of bounds");
        } catch(IllegalStateException e) {
            throw new IllegalMoveException("cell has already been played");
        } catch(IllegalArgumentException e) {
        	throw new IllegalMoveException("Illegal player");
        }

    }

    public int getCell(int cellX, int cellY) {
    	if ((cellX < 0 ||  cellX >= 3) || (cellY < 0 || cellY >= 3))
    		throw new java.lang.IllegalArgumentException("Illegal cell");
    	return board.getCell(cellX, cellY);
    }
    
    private void validatePlayer(int playerId) {
        if (playerId <= 0 || playerId > MAX_PLAYERS) {
            throw new java.lang.IllegalArgumentException("Illegal player");
        }
    }

    public GameResult winner() {
        int playerId = 0;

        // Check for horizontal wins
        int boardSize = this.board.boardSize();

        // Check horizontal and vertical
        for (int i = 0; i < boardSize; i++) {
            if ( this.board.getCell(i, 0) > 0 &&
                 this.board.getCell(i, 0) == this.board.getCell(i, 1) &&
                 this.board.getCell(i, 1) == this.board.getCell(i, 2)) {
                playerId = this.board.getCell(i, 0);
            }
            else if ( this.board.getCell(0, i) > 0 &&
                      this.board.getCell(0, i) == this.board.getCell(1, i) &&
                      this.board.getCell(1, i) == this.board.getCell(2, i)) {
                playerId = this.board.getCell(0, i);
            }
        }
        
        // Check special cases (crosses)
        if (this.board.getCell(1, 1) > 0) {
            if (this.board.getCell(2, 0) == this.board.getCell(1, 1) &&
                this.board.getCell(1, 1) == this.board.getCell(0, 2))
                {
                    playerId = this.board.getCell(1, 1);
                }
            
            if (this.board.getCell(0, 0) == this.board.getCell(1, 1) &&
                this.board.getCell(1, 1) == this.board.getCell(2, 2))
                {
                    playerId = this.board.getCell(1, 1);
                }
        }

        if (playerId == 1) {
            return GameResult.PLAYER_1;
        } else if (playerId == 2) {
            return GameResult.PLAYER_2;
        } else if (this.moves > (boardSize*boardSize - 1)) {
            return GameResult.STALE_MATE;
        } else {
            return GameResult.GAME_IN_PROGRESS;
        }
    }
}
