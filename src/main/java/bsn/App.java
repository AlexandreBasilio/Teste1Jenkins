package bsn;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.File;
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
            //driver.findElement(By.xpath("//*[@id=\"usuario\"]")).sendKeys("testInput");
            driver.manage().window().fullscreen();

            // captude d'ecran
            TakesScreenshot ts = (TakesScreenshot) driver;

            // takes screenShot and put em memory (buffer)
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/images.png"));
            System.out.println("Screenshot takennnnn");

            // Close and quit driver
            driver.close();
            driver.quit();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
