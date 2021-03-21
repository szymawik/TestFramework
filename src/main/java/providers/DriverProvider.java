package providers;

import configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.DriverType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * Created by Wiktor Szymanowski
 * Date: 19.03.2021
 */
public class DriverProvider {

    public WebDriver getDriver() {
        WebDriver driver = null;
        switch (getDriverType()) {
            case CHROME:
                driver = getChromeDriver();
                break;
        }
        return driver;
    }

    private DriverType getDriverType() {
        Configuration configuration = ConfigFactory.create(Configuration.class);
        DriverType driverType;
        String browserName = configuration.browserName().toUpperCase();
        try {
            driverType = DriverType.valueOf(browserName);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Unsupported browserName " + browserName);
        }
        return driverType;
    }

    private WebDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
}
