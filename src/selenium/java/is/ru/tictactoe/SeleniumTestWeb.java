package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import is.ru.tictactoe.SeleniumTestWrapper;
  
  public class SeleniumTestWeb extends SeleniumTestWrapper {
      @Test
      public void titleMatches() {
          driver.get(baseUrl);
          assertEquals("TicTacToe", driver.getTitle());
      }
  
      @Test
      public void assertFirstTest() {
          driver.get(baseUrl);//"/config.html");
          /*
          1. Fill in some name (first name, last name)
          2. Submit form.
          3. Assert that form notifies of success ("Name set as: ...")
          4. Navigate to page to get specific Joke
          5. Enter a specific joke number
          6. Assert the name is used in the joke.
          */
      }
	  
  }