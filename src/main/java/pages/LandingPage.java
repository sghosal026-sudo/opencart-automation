package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    By myAccountOption = By.cssSelector("a[title='My Account']");
    By registerOption = By.linkText("Register");
    By loginOption = By.linkText("Login");

    By searchBox = By.cssSelector("div[id='search'] input");
    By searchBtn = By.cssSelector("div[id='search'] button");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage navigateToRegisterPage() {
        click(myAccountOption);
        click(registerOption);
        return new RegisterPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        click(myAccountOption);
        click(loginOption);
        return new LoginPage(driver);
    }

    public SearchPage performSearch(String product) {
        sendKeys(searchBox, product);
        click(searchBtn);

        return new SearchPage(driver);
    }
}
