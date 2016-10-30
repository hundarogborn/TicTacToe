package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class CliTest {
	
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
}
