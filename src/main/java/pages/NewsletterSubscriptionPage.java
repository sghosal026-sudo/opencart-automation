package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsletterSubscriptionPage extends BasePage {
    public NewsletterSubscriptionPage(WebDriver driver) {
        super(driver);
    }
    
    By subscribeYes = By.xpath("(//input[@name='newsletter'])[1]");
    By subscribeNo = By.xpath("(//input[@name='newsletter'])[2]");
    
    public Boolean isSubscribed() {
        if (isSelected(subscribeYes)) {
            return Boolean.TRUE;
        } else if (isSelected(subscribeNo)) {
            return Boolean.FALSE;
        }
        
        return null;
    }
}
