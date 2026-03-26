package core;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.LandingPage;
import utilities.ConfigReader;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.init();

        WebDriver localDriver = DriverFactory.getDriver();
        localDriver.get(ConfigReader.getProperty("URL"));
        localDriver.manage().window().maximize();

        ContextManager.setContext(new TestContext(localDriver));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quit();
        ContextManager.unload();
    }

    protected WebDriver driver() {
        return ContextManager.getContext().getDriver();
    }

    protected LandingPage landingPage() {
        return ContextManager.getContext().getLandingPage();
    }

    protected SoftAssert softAssert() {
        return ContextManager.getContext().getSoftAssert();
    }
}
