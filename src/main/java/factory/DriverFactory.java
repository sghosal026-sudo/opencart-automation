package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import utilities.ConfigReader;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    public static void init() {
        String browser = ConfigReader.getProperty("BROWSER").toLowerCase();
        
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        WebDriver localDriver;
        
        switch (browser.toLowerCase()) {
            
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                }
                localDriver = new ChromeDriver(chromeOptions);
                break;
            
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                localDriver = new FirefoxDriver(firefoxOptions);
                break;
            
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                }
                localDriver = new EdgeDriver(edgeOptions);
                break;
            
            case "safari":
                if (isHeadless) {
                    throw new RuntimeException("Safari does not support headless mode");
                }
                localDriver = new SafariDriver();
                break;
            
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        
        driver.set(localDriver);
    }
    
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    public static void quit() {
        WebDriver localDriver = driver.get();
        if (localDriver != null) {
            localDriver.quit();
            driver.remove();
        }
    }
}
