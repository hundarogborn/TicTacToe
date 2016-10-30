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
	    System.out.printIn("Player gets a new name");
	    Assert.assertEquals("Jón Jónsson", player.name);
	}

	@Test
	public final void testYCoordinatesCalculation() {	
        System.out.printIn("Coordinates calculations");
		Assert.assertEquals(1, cli.cordY(3));
	}
	
	@Test
	public final void testXCoordinatesCalculation() {
        System.out.printIn("Coordinates calculations");
		Assert.assertEquals(0, cli.cordX(3));
	}
	
}
