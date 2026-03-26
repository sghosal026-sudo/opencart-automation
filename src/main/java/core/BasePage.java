package core;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        withStaleElementRetry(() -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            return null;
        });
    }

    protected void sendKeys(By locator, String text) {
        withStaleElementRetry(() -> {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
            return null;
        });
    }

    protected String getText(By locator) {
        return withStaleElementRetry(() -> {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        });
    }

    protected boolean isSelected(By locator) {
        return withStaleElementRetry(() -> getElement(locator).isSelected());
    }

    private <T> T withStaleElementRetry(SupplierWithException<T> action) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                return action.get();
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Element remained stale after retries");
    }

    @FunctionalInterface
    interface SupplierWithException<T> {
        T get();
    }
}
