package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By loginButton = By.id("login");
    private final By myAccountButton = By.id("myAccount");
    private final By searchField = By.xpath("//div[@id='SearchBoxOld']//div[@role='combobox']/input");
    private final By searchButton = By.xpath("//div[@class='SearchBoxOld-buttonContainer']");

    public void openPage(String url) {
        System.out.println("openPage Method is called.");
        webDriver.get(url);
        pass("Kullanıcı " + url + " sitesini ziyaret eder.");
    }

    public LoginPage openLoginPage() {
        System.out.println("openLoginPage Method is called.");
        click(myAccountButton);
        click(loginButton);
        return new LoginPage(webDriver);
    }

    public boolean checkSearchFiled() {
        return isDisplayed(searchField);
    }

    public ProductListPage searchProduct(String keyword) {
        System.out.println("openLoginPage Method is called.");
        sendKey(searchField, keyword);
        click(searchButton);
        pass("Kullanıcı satın almak istediği ürün için " + keyword + " araması yapar.");
        return new ProductListPage(webDriver);
    }
}
