package bsn.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Utility {

    public static void getScreenShot(WebDriver driver, String fileName) {
        try {
            // captude d'ecran
            TakesScreenshot ts = (TakesScreenshot) driver;
            // takes screenShot and put em memory (buffer)
            File source = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File(fileName));
        } catch (IOException e) {
            System.out.println("Error Screenshot = " + e.getMessage());
        }
        System.out.println("Screenshot taken");
    }

}
