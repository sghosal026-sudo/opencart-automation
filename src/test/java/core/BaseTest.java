package core;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.LandingPage;
import utilities.ConfigReader;

import java.lang.reflect.Method;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public SoftAssert softAssert;
    
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        DriverFactory.init();
        driver = DriverFactory.getDriver();
        
        driver.get(ConfigReader.getProperty("URL"));
        driver.manage().window().maximize();
        
        landingPage = new LandingPage(driver);
        
        softAssert = new SoftAssert();
    }
    
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quit();
    }
}
