package pages.topmenu.maincategories.products;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.topmenu.cart.AddProductsToYourCartPage;

/**
 * Created by Wiktor Szymanowski
 * Date: 19.03.2021
 */
public class ShopPage extends BasePage {

    private AddProductsToYourCartPage addProductsToYourCartPage;

    public ShopPage(WebDriver driver) {
        super(driver);
        addProductsToYourCartPage = new AddProductsToYourCartPage(driver);
    }

    public AddProductsToYourCartPage getAddProductsToYourCartPage() {
        return addProductsToYourCartPage;
    }
}
