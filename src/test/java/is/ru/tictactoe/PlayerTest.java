package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import is.ru.tictactoe.Player;

public class PlayerTest {

	private Player player = new Player();
	private Player player2 = new Player("Player2");

	@Test
	//test empty constucter
	public final void testPlayer() {
		System.out.println("Check name of playerName"); 
		Assert.assertEquals(null, player.getName());
	}
	
	@Test
	//test add name to Player
	public final void testPlayerSetName(){
		System.out.println("Set name of Player");
		Assert.assertEquals(true, player.setName("Player1"));
		Assert.assertEquals("Player1", player.getName());
	}
	
	@Test
	// get the name of the player
	public final void testPlayerGetName(){
		System.out.println("Get the name of Player");
		Assert.assertEquals("Player2", player2.getName());

	}
}

