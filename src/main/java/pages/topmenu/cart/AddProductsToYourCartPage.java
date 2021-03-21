package pages.topmenu.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class AddProductsToYourCartPage extends BasePage {

    @FindBy(css = "#multi-upload-form input[class='tipable activeInput']")
    private List<WebElement> catalogNumberInputs;

    @FindBy(css = "input[class*='quickOrderSubmit']")
    private WebElement addToCart;

    public AddProductsToYourCartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage addToCartByCatalogNumber(String catalogNumber){
        waitForElement(addToCart);
        catalogNumberInputs.get(0).sendKeys(catalogNumber);
        addToCart.click();
        return new CartPage(driver);
    }
}
