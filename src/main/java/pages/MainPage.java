package pages;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.topmenu.TopMenuPage;

/**
 * Created by Wiktor Szymanowski
 * Date: 19.03.2021
 */
public class MainPage extends BasePage {

    private TopMenuPage topMenuPage;

    public MainPage(WebDriver driver) {
        super(driver);
        topMenuPage = new TopMenuPage(driver);
    }

    public TopMenuPage getTopMenuPage() {
        return topMenuPage;
    }
}
