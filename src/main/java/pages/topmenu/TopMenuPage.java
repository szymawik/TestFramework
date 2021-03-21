package pages.topmenu;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

/**
 * Created by Wiktor Szymanowski
 * Date: 19.03.2021
 */
public class TopMenuPage extends BasePage {

    private String products = "a[data-category='Products']";
    private String applicationsAndInsights = "a[data-category='Applications & Insights']";
    private String knowledgeAndSupport = "a[data-category='Knowledge & Support']";
    private String aboutQiagen = "a[data-category='About QIAGEN']";
    private String myQiagen = "a[data-e2e-shadow='myqiagen_login']";
    private String quickOrder = "a[title='Quick Order']";
    private String cart = "a[title='Cart']";

    @FindBy(tagName = "qia-header")
    private WebElement shadowHost;

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public void openCategory(String category) {
        waitForElement(shadowHost);
        String selector = "";
        switch (category){
            case "Products":
                selector = products;
                break;
            case "Applications & Insights":
                selector = applicationsAndInsights;
                break;
            case "Knowledge & Support":
                selector = knowledgeAndSupport;
                break;
            case "About QIAGEN":
                selector = aboutQiagen;
                break;
            case "My QIAGEN":
                selector = myQiagen;
                break;
            case "Quick Order":
                selector = quickOrder;
                break;
            case "Cart":
                selector = cart;
                break;
        }
        WebElement shadowRoot = expandRootElement(shadowHost);
        WebElement element = shadowRoot.findElement(By.cssSelector(selector));
        element.click();
    }
}
