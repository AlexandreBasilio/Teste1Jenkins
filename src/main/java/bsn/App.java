package bsn;

import org.openqa.selenium.WebDriver;
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
            FileInputStream file = new FileInputStream("Test.properties");
            Properties prop = new Properties();
            prop.load(file);
            String browser = prop.getProperty("browser");
            System.out.println("browser=" + browser);
            System.out.println("browser Property=" + prop.getProperty("driverBrowser"));

            if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", prop.getProperty("driverBrowser"));
            } else {
                System.out.println("Browser nao configurado");
            }
            WebDriver driver = new FirefoxDriver();
            driver.get("http://softpost.org");
            driver.manage().window().fullscreen();
            driver.close();
            driver.quit();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
