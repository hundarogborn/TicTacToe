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

		System.out.println("Make invalid move (x=3)");
		try {
			board.makeMove(3,0,0);
			fail();
		} catch(IndexOutOfBoundsException ex) {
			assertEquals("Illegal move", ex.getMessage());
		}

                System.out.println("Make invalid move (x=-1)");
                try {
                        board.makeMove(-1,0,0);
                        fail();
                } catch(IndexOutOfBoundsException ex) {
                        assertEquals("Illegal move", ex.getMessage());
                }

                System.out.println("Make invalid move (y=3)");
                try {
                        board.makeMove(0,3,0);
                        fail();
                } catch(IndexOutOfBoundsException ex) {
                        assertEquals("Illegal move", ex.getMessage());
                }

                System.out.println("Make invalid move (y=-1)");
                try {
                        board.makeMove(0,-1,0);
                        fail();
                } catch(IndexOutOfBoundsException ex) {
                        assertEquals("Illegal move", ex.getMessage());
                }


		System.out.println("Make invalid move (illegal player)");
		try {
			board.makeMove(2,2,3);
			fail();
		} catch(IllegalArgumentException ex) {
			assertEquals("Illegal player", ex.getMessage());
		}

                System.out.println("Make invalid move (neg illegal player)");
                try {
                        board.makeMove(2,2,-1);
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
		assertEquals(Board.GameResult.GAME_IN_PROGRESS, board.winner());

		board.reset();
		assertEquals(true, board.makeMove(0, 0, 1));
		assertEquals(true, board.makeMove(1, 0, 1));
		assertEquals(true, board.makeMove(2, 0, 1));
		assertEquals(Board.GameResult.PLAYER_1, board.winner());

                board.reset();
                assertEquals(true, board.makeMove(0, 0, 2));
                assertEquals(true, board.makeMove(0, 1, 2));
                assertEquals(true, board.makeMove(0, 2, 2));
                assertEquals(Board.GameResult.PLAYER_2, board.winner());

                board.reset();
                assertEquals(true, board.makeMove(0, 2, 2));
                assertEquals(true, board.makeMove(1, 1, 2));
                assertEquals(true, board.makeMove(2, 0, 2));
                assertEquals(Board.GameResult.PLAYER_2, board.winner());

                board.reset();
                assertEquals(true, board.makeMove(2, 0, 1));
                assertEquals(true, board.makeMove(1, 1, 1));
                assertEquals(true, board.makeMove(0, 2, 1));
                assertEquals(Board.GameResult.PLAYER_1, board.winner());

                board.reset();
                assertEquals(true, board.makeMove(0, 0, 1));
                assertEquals(true, board.makeMove(0, 1, 1));
                assertEquals(true, board.makeMove(0, 2, 2));

                assertEquals(true, board.makeMove(1, 0, 2));
                assertEquals(true, board.makeMove(1, 1, 2));
                assertEquals(true, board.makeMove(1, 2, 1));

                assertEquals(true, board.makeMove(2, 0, 1));
                assertEquals(true, board.makeMove(2, 1, 2));
                assertEquals(true, board.makeMove(2, 2, 1));

                assertEquals(Board.GameResult.STALE_MATE, board.winner());


	}

}

