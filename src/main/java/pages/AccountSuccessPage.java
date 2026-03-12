package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class AccountSuccessPage extends BasePage {
    String title = "Your Account Has Been Created!";
    
    By successMessage = By.cssSelector("div[id='content'] h1");
    By continueBtn = By.cssSelector("div[class='buttons'] a");
    
    public AccountSuccessPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean isAccountSuccessPage() {
        return Objects.equals(driver.getTitle(), title);
    }
    
    public String getSuccessMessage() {
        return getText(successMessage);
    }
    
    public AccountPage clickContinue() {
        click(continueBtn);
        return new AccountPage(driver);
    }
}
