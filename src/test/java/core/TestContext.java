package core;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.LandingPage;

public class TestContext {

    private final WebDriver driver;
    private final SoftAssert softAssert;
    private final LandingPage landingPage;

    public TestContext(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
        this.landingPage = new LandingPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    public LandingPage getLandingPage() {
        return landingPage;
    }
}