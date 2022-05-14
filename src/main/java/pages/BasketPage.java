package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By getProductLinkText(String productName) {
        return By.linkText(productName);
    }

    public boolean checkProduct(String productName) {
        return isDisplayed(getProductLinkText(productName));
    }
}