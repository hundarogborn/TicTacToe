package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class BoardTest {
    
    @Test public final void testBoardSize() {
        Assert.assertEquals(3, (new Board()).boardSize());
    }

    @Test public final void testThatBoardIsInitiallyEmpty() {
        Board b = new Board();
        
        for(int y = 0; y < b.boardSize(); y++) {
            for(int x = 0; x < b.boardSize(); x++) {
                assertEquals(-1, b.getCell(x, y));
            }
        }
    }

    // Assert that setCellOnce throws an exception in the
    // case where a cell is set more than once
    @Test
    public final void testSetCellOnceThrows() {
        Board b = new Board();
        b.setCellOnce(0, 0, 1);
        try {
            b.setCellOnce(0, 0, 1);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException ex) {
        }
    }

    // Assert that setCellOnce actually sets values; get them
    // with getCell.
    @Test
    public final void testSetCellOnce() {
        Board b = new Board();

        b.setCellOnce(0, 0, 1);
        assertEquals(1, b.getCell(0, 0));

        b.setCellOnce(1, 1, 2);
        assertEquals(2, b.getCell(1, 1));

        b.setCellOnce(2, 2, 1);
        assertEquals(1, b.getCell(2, 2));
    }
}

