package pages.topmenu.cart;

import models.ProductFromCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.base.BasePage;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class ProductfromCartPage extends BasePage {

    @FindBy(css = "a[class='font-h3']")
    private WebElement name;

    @FindBy(css = ".catNo")
    private WebElement catalogNumber;

    @FindBy(css = "#quantity")
    private WebElement quantity;

    @FindBy(css = ".price-value")
    private WebElement price;

    @FindBy(css = ".subtotal-value")
    private WebElement subtotal;

    public ProductfromCartPage(WebDriver driver, WebElement element) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    public ProductFromCart toCartProduct(){
        return new ProductFromCart(name.getText(), Integer.parseInt(catalogNumber.getText().substring(catalogNumber.getText().indexOf(": ")+2)), Integer.parseInt(quantity.getAttribute("value")), getDecimal(price), getDecimal(subtotal));
    }
}
