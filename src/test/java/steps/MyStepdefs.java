package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.topmenu.cart.CartPage;
import pages.topmenu.maincategories.ProductsPage;
import pages.topmenu.maincategories.products.ShopPage;
import providers.DriverContainer;

/**
 * Created by Wiktor Szymanowski
 * Date: 19.03.2021
 */
public class MyStepdefs {

    private WebDriver driver;

    @Given("^the user goes to Cart link$")
    public void theUserGoesToCartLink() {
        driver = DriverContainer.getDriver();
        new MainPage(driver)
                .getTopMenuPage()
                .openCategory("Cart");
    }

    @Given("^the user goes to Shop subcategory$")
    public void theUserGoesToShopSubcategory() {
        driver = DriverContainer.getDriver();
        new MainPage(driver)
                .getTopMenuPage()
                .openCategory("Products");
        new ProductsPage(driver).goToSubcategory("Shop");
    }

    @When("^the user adds product \"([^\"]*)\" to cart through Cart Page$")
    public void theUserAddsProductToCartThroughCartPage(String catalogNumber) {
        new CartPage(driver)
                .getAddProductsToYourCartPage()
                .addToCartByCatalogNumber(catalogNumber);
    }

    @When("^the user adds product \"([^\"]*)\" to cart through Shop page$")
    public void theUserAddsProductToCartThroughShopPage(String catalogNumber) {
        new ShopPage(driver)
                .getAddProductsToYourCartPage()
                .addToCartByCatalogNumber(catalogNumber);
    }

    @Then("^the product \"([^\"]*)\" is added to cart$")
    public void theProductIsAddedToCart(String catalogNumber) {
        new CartPage(driver)
                .validatePresenceOfProductByCatalogNumber(catalogNumber);
    }

}
