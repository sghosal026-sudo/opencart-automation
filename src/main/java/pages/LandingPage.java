package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    public LandingPage(WebDriver driver) {
        super(driver);
    }
    
    By myAccountOption = By.cssSelector("a[title='My Account']");
    By registerOption = By.linkText("Register");
    By loginOption = By.linkText("Login");
    
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
}
