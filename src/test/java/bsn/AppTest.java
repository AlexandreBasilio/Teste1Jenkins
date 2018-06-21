package bsn;

import static org.junit.Assert.assertTrue;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    @Test
    public void test1()
    {
       //Selenium Test;
        // After selenium 3.0 we can not execute directly, its necessary l epath
        System.setProperty("webdriver.gecko.driver", "C:\\Java\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://softpost.org");
        driver.close();
        driver.quit();

    }
}
