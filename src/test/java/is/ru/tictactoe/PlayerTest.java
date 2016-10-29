package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import is.ru.tictactoe.Player;

public class PlayerTest {

	// for Player tests
	private Player player = new Player("Player");

	@Test
	//test empty constucter
	public final void testPlayer() {}
	
	@Test
	// get the name of the player
	public final void testgetName(){
		
		System.out.println("Get the name of Player");
		Assert.assertEquals("Player", player.getName());
		
	}
	
	@Test
	// check if the player is humanplayer
	public final void testisHuman(){
		player.setHuman(true);
		
		System.out.println("Check if humanplayer");
		Assert.assertEquals(true, player.isHuman());
	}
	
	@Test
	// get set win, looses and draws of the player
	public final void testgetResults(){
		
		System.out.println("Set win to the Player");
		Assert.assertEquals(1, player.addWin());
		
		System.out.println("Set game played to the Player");
		Assert.assertEquals(1, player.addGamesPlayed());
		
		System.out.println("Get wins of the Player");
		Assert.assertEquals(1, player.getWins());
		
		System.out.println("Get games played of the Player");
		Assert.assertEquals(1, player.getGamesPlayed());
	
	}
}
