package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import is.ru.tictactoe.Player;

public class PlayerTest {

	private Player player = new Player();
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
		System.out.println("Get the name of Player");
		Assert.assertEquals("Player", playerName.getName());

	}
}
