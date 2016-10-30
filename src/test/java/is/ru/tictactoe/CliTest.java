package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class CliTest {

/*
	@Test
	public final void testPrintBoar() {
		char[] cell = new char[9];
	for(int index = 0; index < 9; index++) 
		coordinates cord = getCellCords(index);
		int token = game.getCell(cord.x, cord.y);

		if(token == 1)
			assertEquals('X', cell[index]);
		else if(token == 2)
			assertEquals('O', cell[index]);
		else 
			assertEquals(' ', cell[index]);

	}
*/


	//Player player = new Player(3);
	
	@Test
	public final void testPlayerGetsNewName() {
		String name = "NN";
		Player player = new Player(name);
		assertEquals("NN", player.name);
	}

	@Test
	public final void testYCoordinatesCalculation() {	
		Cli c = new Cli();
		assertEquals(1, c.setCordy(3));
	}
	

	@Test
	public final void testXCoordinatesCalculation() {
		Cli c = new Cli();
		assertEquals(0, c.setCordx(3));
	}

/*
	@Test
	public final void testIfPlayAgainReturnsFalseIfNIsTyped() {
		
		assertEquals(false, Cli.playAgain.sc.next())	

	}*/
}
