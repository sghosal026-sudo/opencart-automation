package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    By productNameText = By.cssSelector("div[class*='product-thumb'] h4");
    By productNotPresentMessage = By.cssSelector("div[id='content'] p:last-of-type");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNotPresentMessage() {
        return getText(productNotPresentMessage);
    }

    public boolean isProductFound(String product) {
        List<WebElement> products = getAllProducts();

        for (WebElement webElement : products) {
            if (webElement.getText().equals(product)) {
                return true;
            }
        }

        return false;
    }

    private List<WebElement> getAllProducts() {
        return driver.findElements(productNameText);
    }
}
