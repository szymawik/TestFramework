package pages.topmenu.cart;

import models.ProductFromCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class CartPage extends BasePage {

    @FindBy(css = "#cartTable tbody tr")
    private List<WebElement> products;

    @FindBy(css = "#qiaCheckout1 a")
    private WebElement beginCheckout;

    private AddProductsToYourCartPage addProductsToYourCartPage;

    public CartPage(WebDriver driver) {
        super(driver);
        addProductsToYourCartPage = new AddProductsToYourCartPage(driver);
    }

    public CartPage validatePresenceOfProductByCatalogNumber(String expectedCatalogNumber){
        waitForElement(beginCheckout);
        List<ProductFromCart> productsInCart = getOrder();
        assertThat(productsInCart)
                .extracting(ProductFromCart::getCatalogNumber)
                .anyMatch(actualCatalogNumber -> actualCatalogNumber.toString().equals(expectedCatalogNumber));
        return this;
    }

    public AddProductsToYourCartPage getAddProductsToYourCartPage() {
        return addProductsToYourCartPage;
    }

    private List<ProductFromCart> getOrder(){
        return products.stream().map(product -> new ProductfromCartPage(driver, product).toCartProduct()).collect(Collectors.toList());
    }
}
