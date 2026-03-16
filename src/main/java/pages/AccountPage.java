package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class AccountPage extends BasePage {
    String title = "My Account";

    By newsletterOption = By.xpath("//li/a[contains(text(),'subscribe')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountPage() {
        wait.until(ExpectedConditions.titleIs(title));
        return Objects.equals(driver.getTitle(), title);
    }

    public NewsletterSubscriptionPage clickOnNewsletterOption() {
        click(newsletterOption);
        return new NewsletterSubscriptionPage(driver);
    }
}
