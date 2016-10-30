package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class CliTest {
	
	private Cli cli = new Cli ();
	
	@Test
	public final void testPlayerGetsNewName() {
	    String name = "Jón Jónsson";
	    Player player = new Player(name);
	    Assert.assertEquals("Jón Jónsson", player.name);
	}

	@Test
	public final void testYCoordinatesCalculation() {	
		Assert.assertEquals(1, cli.cordY(3));
	}
	
	@Test
	public final void testXCoordinatesCalculation() {
		Assert.assertEquals(0, cli.cordX(3));
	}
	
}
