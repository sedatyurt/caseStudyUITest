package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage extends BasePage {

    public ProductListPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By minPriceField = By.xpath("/html//div[@id='fiyat']/div/div/div//div[@class='facetCommon-facetInputContent rangeFilterInput-inputContainer']/div[1]/input");
    private final By maxPriceField = By.xpath("/html//div[@id='fiyat']/div/div/div//div[@class='facetCommon-facetInputContent rangeFilterInput-inputContainer']/div[2]/input");
    private final By filterPriceButton = By.xpath("//div[@id='fiyat']/div/div/div//button");
    private final By productCardName = By.xpath("//h3[@data-test-id='product-card-name']");
    private final By collapseTitle = By.xpath("//div[@data-test-id='collapse-title']");

    public boolean checkCollapseTitle() {
        return isDisplayed(collapseTitle);
    }

    private void switchToNewTabProduct() {
        switchToNewTab();
    }

    private void scrollToIndexProductList() {
        waitSeconds(2);
        scrollToIndex();
    }

    public void priceFilterAsPrice(String minPrice, String maxPrice) {
        System.out.println("priceFilter method is called.");
        scrollToIndexProductList();
        sendKey(minPriceField, minPrice);
        sendKey(maxPriceField, maxPrice);
        click(filterPriceButton);
        refreshPage();
        pass("Kullanıcı arama sonucunda fiyat aralığı olarak " + minPrice + " - " + maxPrice + " filtrelemesi yapar.");
    }

    private void scrollToBottomProductList() {
        waitSeconds(2);
        scrollToBottom();
    }

    public String getProductName() {
        System.out.println("getProductName method is called.");
        scrollToBottomProductList();
        List<WebElement> productNames = webDriver.findElements(productCardName);
        String productName = getText(productNames.get(productNames.size() - 2));
        System.out.println("Product name is " + productName + ".");
        return productName;
    }

    public ProductPage goProduct() {
        System.out.println("goProduct method is called.");
        List<WebElement> productNames = webDriver.findElements(productCardName);
        click(productNames.get(productNames.size() - 2));
        switchToNewTabProduct();
        pass("Kullanıcı, Filtrelenen sonuçta ekrana gelen ürün listesinde en alt satırdan rastgele bir ürün seçer ve ürün detayına gider");
        return new ProductPage(webDriver);
    }
}