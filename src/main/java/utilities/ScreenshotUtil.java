package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {
    
    public static String captureScreenshot(WebDriver driver, String testName) {
        
        try {
            
            String folder = RunManager.getRunFolder() + "/screenshots/";
            
            String fileName = testName.replaceAll("[^a-zA-Z0-9._-]", "_")
                    + "_" + System.currentTimeMillis() + ".png";
            
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            Files.copy(src.toPath(), Paths.get(folder + fileName));
            
            return "screenshots/" + fileName;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}