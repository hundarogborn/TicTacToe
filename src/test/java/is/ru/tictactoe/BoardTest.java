package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import is.ru.tictactoe.Board;

public class BoardTest {

	private Board board = new Board();

	@Test
	public final void testBoard() {
	}

	@Test
	public final void testMakeMove() {
		System.out.println("Inside makeMove()"); 

		System.out.println("Make valid move (empty cell)"); 
		Assert.assertEquals(true, board.makeMove(0, 0, 1));
		
		System.out.println("Make invalid move (occupied cell)");
		Assert.assertEquals(false, board.makeMove(0, 0, 1));
        
		System.out.println("Make invalid move (out of bounds)");
		try {
            board.makeMove(3,3,0);
            fail();
        } catch(IndexOutOfBoundsException ex) {
            assertEquals("Illegal move", ex.getMessage());
        }

		System.out.println("Make invalid move (illegal player)");
        try {
            board.makeMove(2,2,2);
            fail();
        } catch(IllegalArgumentException ex) {
            assertEquals("Illegal player", ex.getMessage());
        }

	}

	@Test
	public final void testGetCell() {
		System.out.println("Inside getCell()");
        assertEquals(0, board.getCell(0,0));
        assertEquals(0, board.getCell(2,2));
	}

	@Test
	public final void testWinner() {
		System.out.println("Inside Winner()");
        assertEquals(0, board.winner());
	}

}

