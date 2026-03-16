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

        WebDriver localDriver = DriverFactory.getDriver();
        localDriver.get(ConfigReader.getProperty("URL"));
        localDriver.manage().window().maximize();

        TestContext context = new TestContext(localDriver);
        ContextManager.setContext(context);

        driver = context.getDriver();
        softAssert = context.getSoftAssert();
        landingPage = context.getLandingPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        ContextManager.getContext().getDriver().quit();
        ContextManager.unload();
    }
}
