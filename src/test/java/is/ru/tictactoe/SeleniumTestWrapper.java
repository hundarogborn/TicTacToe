package is.ru.tictactoe;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;



public abstract class SeleniumTestWrapper {
    static ChromeDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        port = System.getenv("PORT");
        if (port == null) {
            port = "80";
        }
        baseUrl = "http://salty-woodland-44662.herokuapp.com/" + port;
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}