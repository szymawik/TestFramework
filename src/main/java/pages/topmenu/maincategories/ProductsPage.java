package pages.topmenu.maincategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

/**
 * Created by Wiktor Szymanowski
 * Date: 19.03.2021
 */
public class ProductsPage extends BasePage {

    private String discoveryAndTranslationalResearch = "a[title='Discovery & Translational Research']";
    private String diagnosticsAndClinicalResearch = "a[title='Diagnostics & Clinical Research']";
    private String humanIdAndForensics = "a[title='Human ID & Forensics']";
    private String nextGenerationSequencing = "a[title='Next-Generation Sequencing']";
    private String instrumentsAndAutomation = "a[title='Instruments & Automation']";
    private String informaticsAndData = "a[title='Informatics & Data']";
    private String oemByQiagen = "a[title='OEM by QIAGEN']";
    private String covid19 = "a[title='COVID-19']";
    private String topSellers = "a[title='Top Sellers']";
    private String shop = "a[title='Shop']";

    @FindBy(tagName = "qia-header")
    private WebElement shadowHost;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void goToSubcategory(String subCategory) {
        waitForElement(shadowHost);
        String selector = "";
        switch (subCategory){
            case "Discovery & Translational Research":
                selector = discoveryAndTranslationalResearch;
                break;
            case "Diagnostics & Clinical Research":
                selector = diagnosticsAndClinicalResearch;
                break;
            case "Human ID & Forensics":
                selector = humanIdAndForensics;
                break;
            case "Next-Generation Sequencing":
                selector = nextGenerationSequencing;
                break;
            case "Instruments & Automation":
                selector = instrumentsAndAutomation;
                break;
            case "Informatics & Data":
                selector = informaticsAndData;
                break;
            case "OEM by QIAGEN":
                selector = oemByQiagen;
                break;
            case "COVID-19":
                selector = covid19;
                break;
            case "Top Sellers":
                selector = topSellers;
                break;
            case "Shop":
                selector = shop;
                break;
        }
        WebElement shadowRoot = expandRootElement(shadowHost);
        WebElement shadowHost2 = shadowRoot.findElement(By.tagName("qia-navigation-flyout"));
        WebElement shadowRoot2 = expandRootElement(shadowHost2);
        WebElement element = shadowRoot2.findElement(By.cssSelector(selector));
        element.click();
    }
}
