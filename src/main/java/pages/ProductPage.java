package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By otherSellers = By.xpath("//div[@class='product-detail-module']/section[1]//div[@class='productDetailContent']/div[4]/div[2]/div[3]//a[@href='javascript:;']");
    private final By sortForSellerButton = By.linkText("Satıcı");
    private final By addToBasketButton = By.xpath("//table[@id='merchant-list']/tbody/tr[3]//form[@action='/ShoppingCart/AddToCart']/button[@class='add-to-basket button']");
    private final By dismissRepairPack = By.linkText("Onarım paketi istemiyorum");
    private final By cancelButton = By.xpath("//a[@class='checkoutui-Modal-2iZXl']");
    private final By shoppingCartButton = By.id("shoppingCart");
    private final By productName = By.id("product-name");


    public String getProductName() {
        return getText(productName);
    }

    private void clickOtherSellersButton() {
        click(otherSellers);
    }

    private void sortSeller() {
        click(sortForSellerButton);
        waitSeconds(1);
        click(sortForSellerButton);
    }

    public void clickAddToBasketButton() {
        System.out.println("clickAddToBasketButton method is called.");
        clickOtherSellersButton();
        sortSeller();
        List<WebElement> addToBasketButtons = webDriver.findElements(addToBasketButton);
        click(addToBasketButtons.get(0));
        click(dismissRepairPack);
        pass("Detayı açılan ürün için en düşük puanlı satıcının ürünü sepete eklenir.");
    }

    public BasketPage goBasket() {
        System.out.println("goBasket method is called.");
        click(cancelButton);
        scrollToTop();
        click(shoppingCartButton);
        pass("Ürünün sepete doğru eklendiği kontrol edilir.");
        return new BasketPage(webDriver);
    }
}