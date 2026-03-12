package core;

import org.openqa.selenium.*;
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
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    protected void click(By locator) {
        retry(() -> {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        });
    }
    
    protected void sendKeys(By locator, String text) {
        retry(() -> {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
        });
    }
    
    protected String getText(By locator) {
        return retryWithReturn(() -> {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        });
    }
    
    protected boolean isSelected(By locator) {
        return retryWithReturn(() -> getElement(locator).isSelected());
    }
    
    private void retry(Runnable action) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                action.run();
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Element remained stale after retries");
    }
    
    private <T> T retryWithReturn(SupplierWithException<T> action) {
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