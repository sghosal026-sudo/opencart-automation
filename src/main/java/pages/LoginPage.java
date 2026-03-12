package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    By newCustomerContinueBtn = By.cssSelector("div[class='well'] a[class*='btn']");
    By registerOption = By.cssSelector("div[class='list-group'] a:nth-of-type(2)");
    
    public RegisterPage clickNewCustomerContinueBtn() {
        click(newCustomerContinueBtn);
        return new RegisterPage(driver);
    }
    
    public RegisterPage clickRegisterOption() {
        click(registerOption);
        return new RegisterPage(driver);
    }
}
