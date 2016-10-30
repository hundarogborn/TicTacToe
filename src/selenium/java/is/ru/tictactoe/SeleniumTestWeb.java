package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import is.ru.tictactoe.SeleniumTestWrapper;
import org.openqa.selenium.By;
  
  public class SeleniumTestWeb extends SeleniumTestWrapper {
      @Test
      public void titleMatches() {
          driver.get(baseUrl);
          assertEquals("TicTacToe", driver.getTitle());
      }
  
	  @Test
	  public void testUntitled3() throws Exception {
		driver.get(baseUrl);
		assertEquals("TicTacToe", driver.getTitle());
		driver.findElement(By.name("player1")).clear();
		driver.findElement(By.name("player1")).sendKeys("Diddi");
		driver.findElement(By.name("player2")).clear();
		driver.findElement(By.name("player2")).sendKeys("Svenni");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("TicTacToe", driver.getTitle());
		}
  }