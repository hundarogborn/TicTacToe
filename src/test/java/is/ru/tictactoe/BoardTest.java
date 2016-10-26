package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class BoardTest {
    
	@Test
	public final void testBoardSize() {
        Assert.assertEquals(1, (new Board(1)).boardSize());
        Assert.assertEquals(3, (new Board(3)).boardSize());
        Assert.assertEquals(5, (new Board(5)).boardSize());
        Assert.assertEquals(13, (new Board(13)).boardSize());
	}

	@Test
	public final void testThatBoardIsInitiallyEmpty() {
        Board b = new Board(3);
        
        for(int y = 0; y < b.boardSize(); y++) {
            for(int x = 0; x < b.boardSize(); x++) {
                assertEquals(-1, b.getCell(x, y));
            }
        }
	}
}

