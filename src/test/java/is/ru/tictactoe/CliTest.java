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
		Assert.assertEquals("0, 0", cli.getCellCords(index));
	}
	
	@Test
	public final void testPlayerGetsNewName() {
		String name = "NN";
		Player player = new Player(name);
		assertEquals("NN", player.name);
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
