package pages.base;

import configuration.Logs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * Created by Wiktor Szymanowski
 * Date: 19.03.2021
 */
public class BasePage {

    protected WebDriver driver;
    private Actions actionBuilder;
    private WebDriverWait wait;
    private Logs log = new Logs(this.getClass().getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actionBuilder = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    protected void waitForElement(WebElement element) {
        log.info("Wait for element", element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void moveToElement(WebElement element) {
        actionBuilder.moveToElement(element).perform();
    }

    protected WebElement getRandomElement(List<WebElement> elements){
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size()));
    }

    protected WebElement expandRootElement(WebElement element) {
        return (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", element);
    }

    protected BigDecimal getDecimal(WebElement element) {
        return new BigDecimal(element.getText().replace("$", ""));
    }
}
