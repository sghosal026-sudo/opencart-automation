package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class ForgotPasswordPage extends BasePage {
    String title = "Forgot Your Password?";
    By emailField = By.id("input-email");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean isForgotPasswordPage() {
        wait.until(ExpectedConditions.titleIs(title));

        return Objects.equals(driver.getTitle(), title);
    }
}
