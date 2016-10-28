package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class EngineTest {

    private Engine engine = new Engine();

    @Test
    public final void testMakeMove() throws IllegalMoveException {
        System.out.println("Inside makeMove()"); 

        System.out.println("Make valid move (empty cell)"); 
        engine.makeMove(0, 0, 1);
        
        System.out.println("Make invalid move (occupied cell)");

        try {
            engine.makeMove(0, 0, 1);
            fail();
        } catch(IllegalMoveException ex) {
        }

        System.out.println("Make invalid move (x=3)");
        try {
            engine.makeMove(3,0,1);
            fail();
        } catch(IllegalMoveException ex) {
            assertEquals("move is out of bounds", ex.getMessage());
        }
        
        System.out.println("Make invalid move (x=-1)");
        try {
            engine.makeMove(-1,0,1);
            fail();
        } catch(IllegalMoveException ex) {
            assertEquals("move is out of bounds", ex.getMessage());
        }
        
        System.out.println("Make invalid move (y=3)");
        try {
            engine.makeMove(0,3,1);
            fail();
        } catch(IllegalMoveException ex) {
            assertEquals("move is out of bounds", ex.getMessage());
        }
        
        System.out.println("Make invalid move (y=-1)");
        try {
            engine.makeMove(0,-1,1);
            fail();
        } catch(IllegalMoveException ex) {
            assertEquals("move is out of bounds", ex.getMessage());
        }

        System.out.println("Make invalid move (illegal player)");
        try {
            engine.makeMove(2,2,3);
            fail();
        } catch(IllegalMoveException ex) {
            assertEquals("Illegal player", ex.getMessage());
        }

        System.out.println("Make invalid move (neg illegal player)");
        try {
            engine.makeMove(2,2,-1);
            fail();
        } catch(IllegalMoveException ex) {
            assertEquals("Illegal player", ex.getMessage());
        }
        
    }

    @Test
    public final void testWinner() throws IllegalMoveException {
        Engine e = new Engine();
        System.out.println("Inside Winner()");
        assertEquals(Engine.GameResult.GAME_IN_PROGRESS, e.winner());
        
        e = new Engine();
        e.makeMove(0, 0, 1);
        e.makeMove(1, 0, 1);
        e.makeMove(2, 0, 1);
        assertEquals(Engine.GameResult.PLAYER_1, e.winner());
        
        e = new Engine();
        e.makeMove(0, 0, 2);
        e.makeMove(0, 1, 2);
        e.makeMove(0, 2, 2);
        assertEquals(Engine.GameResult.PLAYER_2, e.winner());

        e = new Engine();
        e.makeMove(0, 2, 2);
        e.makeMove(1, 1, 2);
        e.makeMove(2, 0, 2);
        assertEquals(Engine.GameResult.PLAYER_2, e.winner());
        
        e = new Engine();
        e.makeMove(2, 0, 1);
        e.makeMove(1, 1, 1);
        e.makeMove(0, 2, 1);
        assertEquals(Engine.GameResult.PLAYER_1, e.winner());

        e = new Engine();
        e.makeMove(0, 0, 1);
        e.makeMove(0, 1, 1);
        e.makeMove(0, 2, 2);

        e.makeMove(1, 0, 2);
        e.makeMove(1, 1, 2);
        e.makeMove(1, 2, 1);

        e.makeMove(2, 0, 1);
        e.makeMove(2, 1, 2);
        e.makeMove(2, 2, 1);

        assertEquals(Engine.GameResult.STALE_MATE, e.winner());
    }

}

