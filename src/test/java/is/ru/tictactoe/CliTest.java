package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class CliTest {


//	Cli c = new Cli();

	@Test
	public final void testPrintBoard() {
		char[] cell = new char[9];
	for(int index = 0; index < 9; index++) 
		coordinates cord = getCellCords(index);
		int token = game.getCell(cord.x, cord.y);

		if(token == 1)
			assertEquals('X', cell[index]);
		else if(token == 2)
			asserEquals('O', cell[index]);
		else 
			asserEquals(' ', cell[index]);

	}

	
	//Player player = new Player(3);
	/*
	@Test
	public final void testSetPlayer(1) {
		assertEquals("Player 1", Player + num + name);
	}
*/

}
