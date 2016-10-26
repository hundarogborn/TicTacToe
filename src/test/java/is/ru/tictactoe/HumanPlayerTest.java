package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import is.ru.tictactoe.HumanPlayer;

public class HumanPlayerTest {

	// for EmptyPlayer tests
	private HumanPlayer player = new HumanPlayer();
	private Board board = new Board();
	
	
	private Player playerName = new Player("Player");

	@Test
	//test empty constucter
	public final void testPlayer() {
	}
	
	@Test
	//test add name to Player
	public final void testsetName(){
		System.out.println("Set name of Player");
		Assert.assertEquals(true, player.setName("Player2"));
	}
	
	@Test
	// get the name of the player
	public final void testgetName(){
		player.setName("Player2");
		
		System.out.println("Get the name of Player");
		Assert.assertEquals("Player", playerName.getName());
		
		System.out.println("Get the name of Player2");
		Assert.assertEquals("Player2", player.getName());

	}
	
	@Test
	// get set win, looses and draws of the player
	public final void testgetResults(){
		
		
		System.out.println("Set win to the Player");
		Assert.assertEquals(1, player.addWin());
		
		System.out.println("Set draw to the Player");
		Assert.assertEquals(1, player.addDraw());
		
		System.out.println("Set win to the Player");
		Assert.assertEquals(1, player.addLoose());
		
		System.out.println("Get wins of the Player");
		Assert.assertEquals(1, player.getWins());
		
		System.out.println("Get draws of the Player");
		Assert.assertEquals(1, player.getDraws());
		
		System.out.println("Get wins of the Player");
		Assert.assertEquals(1, player.getLooses());
				
	}
	@Test
	// Make a move
	public final void testmakeMove(){
		System.out.println("Make move");
		Assert.assertEquals(true, player.playerMove(board, 1));
	}
}
