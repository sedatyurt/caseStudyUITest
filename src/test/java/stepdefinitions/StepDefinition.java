package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

@RunWith(Cucumber.class)
public class StepDefinition {

    HomePage homePage;
    LoginPage loginPage;
    ProductListPage productListPage;
    ProductPage productPage;
    BasketPage basketPage;
    String productName;

    WebDriver webDriver = DriverManager.getWebDriver();

    @Given("^The user visits the website \"([^\"]*)\"$")
    public void the_user_visits_the_website_something(String strArg1) {
        homePage = new HomePage(webDriver);
        homePage.openPage(strArg1);
        Assert.assertTrue(homePage.checkSearchFiled());
    }

    @When("^The user logs in \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_user_logs_in_something_and_something(String strArg1, String strArg2) {
        loginPage = homePage.openLoginPage();
        homePage = loginPage.beLogin(strArg1, strArg2);
        Assert.assertTrue(homePage.checkSearchFiled());
    }

    @And("^The user searches for \"([^\"]*)\" for the product he wants to buy$")
    public void the_user_searches_for_something_for_the_product_he_wants_to_buy(String strArg1) {
        productListPage = homePage.searchProduct(strArg1);
        Assert.assertTrue(productListPage.checkCollapseTitle());
    }

    @And("^The user filters \"([^\"]*)\" – \"([^\"]*)\" as the price range in the search result$")
    public void the_user_filters_something_something_as_the_price_range_in_the_search_result(String strArg1, String strArg2) {
        productListPage.priceFilterAsPrice(strArg1, strArg2);
        Assert.assertTrue(productListPage.checkCollapseTitle());

    }

    @And("^The user selects a random product from the bottom line in the product list displayed in the filtered result and goes to the product details$")
    public void the_user_selects_a_random_product_from_the_bottom_line_in_the_product_list_displayed_in_the_filtered_result_and_goes_to_the_product_details() {
        productName = productListPage.getProductName();
        System.out.println(productName);
        productPage = productListPage.goProduct();
        Assert.assertEquals(productPage.getProductName(), productName);
    }

    @And("^For the product whose details are opened, the product of the seller with the lowest score is added to the cart$")
    public void for_the_product_whose_details_are_opened_the_product_of_the_seller_with_the_lowest_score_is_added_to_the_cart() throws Throwable {
        productPage.clickAddToBasketButton();
    }

    @Then("^It is checked that the product has been added to the basket correctly$")
    public void it_is_checked_that_the_product_has_been_added_to_the_basket_correctly() {
        basketPage = productPage.goBasket();
        Assert.assertTrue(basketPage.checkProduct(productName));
    }
}