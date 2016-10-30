package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class CliTest {
	
	private Cli cli = new Cli ();
	
	@Test
	public final void testPrint() {
		String string = "Testing testing, 1, 2, 3";
		
		System.out.printIn("Testing print function");
		Assert.assertEquals("Testing testing, 1, 2, 3", cli.print(string));
	}
	
	@Test
	public final void testPrintIn() {
		String string = "Testing testing, 1, 2, 3";
		
		System.out.printIn("Testing printin function");
		Assert.assertEquals("Testing testing, 1, 2, 3", cli.printIn(string));
	}
	
	@Test
	public final void testGetCellCords() {
		int index = 1;
		
		System.out.printIn("Get cell cordinants for index 1");
		Assert.assertEquals(1, cli.getCellCords(index));
	}
	
	@Test
	public final void testPlayerGetsNewName() {
		String name = "NN";
		Player player = new Player(name);
		assertEquals(name, player.name);
	}

	@Test
	public final void testYCoordinatesCalculation() {	
<<<<<<< HEAD

		Assert.assertEquals(1, cli.setCordy(3));
=======
		Cli c = new Cli();
		assertEquals(1, c.cordY(3));
>>>>>>> b2851c661c8fb4aa6acc7da5a5058a744a62ef9b
	}
	
	@Test
	public final void testXCoordinatesCalculation() {
<<<<<<< HEAD

		Assert.assertEquals(0, cli.setCordx(3));
=======
		Cli c = new Cli();
		assertEquals(0, c.cordX(3));
>>>>>>> b2851c661c8fb4aa6acc7da5a5058a744a62ef9b
	}
	
}
