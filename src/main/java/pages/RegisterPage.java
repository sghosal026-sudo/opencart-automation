package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class RegisterPage extends BasePage {
    String title = "Register Account";
    
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By subscribeYes = By.xpath("//input[@name='newsletter' and @value='1']");
    By subscribeNo = By.xpath("//input[@name='newsletter' and @value='0']");
    By privacyPolicy = By.name("agree");
    By continueButton = By.cssSelector("input[type='submit']");
    
    By firstNameErrorMsg = By.xpath("(//div[@class = 'text-danger'])[1]");
    By lastNameErrorMsg = By.xpath("(//div[@class = 'text-danger'])[2]");
    By emailErrorMsg = By.xpath("(//div[@class = 'text-danger'])[3]");
    By telephoneErrorMsg = By.xpath("(//div[@class = 'text-danger'])[4]");
    By passwordErrorMsg = By.xpath("(//div[@class = 'text-danger'])[5]");
    By warningMsg = By.cssSelector("div[class*='alert']");
    
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean isRegisterPage() {
        return Objects.equals(driver.getTitle(), title);
    }
    
    public AccountSuccessPage performRegistration(String fName, String lName, String emailAddress, String phone, String pwd, boolean subscribe, boolean acceptTerms) {
        sendKeys(firstName, fName);
        sendKeys(lastName, lName);
        sendKeys(email, emailAddress);
        sendKeys(telephone, phone);
        sendKeys(password, pwd);
        sendKeys(confirmPassword, pwd);
        if (subscribe) {
            click(subscribeYes);
        } else {
            click(subscribeNo);
        }
        
        if (acceptTerms) {
            click(privacyPolicy);
        }
        
        click(continueButton);
        
        return new AccountSuccessPage(driver);
    }
    
    public String getFirstNameErrorMessage() {
        return getText(firstNameErrorMsg);
    }
    
    public String getLastNameErrorMessage() {
        return getText(lastNameErrorMsg);
    }
    
    public String getEmailErrorMessage() {
        return getText(emailErrorMsg);
    }
    
    public String getTelephoneErrorMessage() {
        return getText(telephoneErrorMsg);
    }
    
    public String getPasswordErrorMessage() {
        return getText(passwordErrorMsg);
    }
    
    public String getWarningMessage() {
        return getText(warningMsg);
    }
}
