package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class LoginPage extends BasePage {
    String title = "Account Login";

    By newCustomerContinueBtn = By.cssSelector("div[class='well'] a[class*='btn']");
    By registerOption = By.cssSelector("div[class='list-group'] a:nth-of-type(2)");
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginBtn = By.cssSelector("input[value='Login']");
    By forgotPasswordLink = By.linkText("Forgotten Password");
    By unsuccessfulLoginWarning = By.cssSelector("div[class*='alert']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPage() {
        wait.until(ExpectedConditions.titleIs(title));
        return Objects.equals(driver.getTitle(), title);
    }

    public RegisterPage clickNewCustomerContinueBtn() {
        click(newCustomerContinueBtn);
        return new RegisterPage(driver);
    }

    public RegisterPage clickRegisterOption() {
        click(registerOption);
        return new RegisterPage(driver);
    }

    public AccountPage performLogin(String email, String password) {
        sendKeys(emailField, email);
        sendKeys(passwordField, password);
        click(loginBtn);

        return new AccountPage(driver);
    }

    public String getUnsuccessfulLoginWarningMsg() {
        return getText(unsuccessfulLoginWarning);
    }

    public boolean isForgotPasswordLinkPresent() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink));

        return element != null;
    }
}
