package bsn;

import bsn.utils.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!!!222!" );
        try {

            // Read properties file
            FileInputStream file = new FileInputStream("Test.properties");
            Properties prop = new Properties();
            prop.load(file);

            // print properties from file .properties
            String browser = prop.getProperty("browser");
            System.out.println("browser=" + browser);
            System.out.println("browser Property=" + prop.getProperty("driverBrowser"));

            // test browser
            if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", prop.getProperty("driverBrowser"));
            } else {
                System.out.println("Browser nao configurado");
            }

            // open browser - WebDriver
            WebDriver driver = new FirefoxDriver();
            driver.get("http://uol.com.br");
            WebElement webElement = driver.findElement(By.xpath("//*[@id=\"usuario\"]"));
            System.out.println("webElement getText=" + webElement.getLocation().x);
            webElement.sendKeys("testOK");
            //driver.findElement(By.xpath("//*[@id=\"usuario\"]"))
            // .sendKeys("testInput");
            driver.manage().window().fullscreen();

            // Capture d'ecran
            Utility.getScreenShot(driver, "imagem.png");

            // Close and quit driver
            driver.close();
            driver.quit();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
