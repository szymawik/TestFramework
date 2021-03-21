package providers;

import org.openqa.selenium.WebDriver;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class DriverContainer {

    private static ThreadLocal<WebDriver> driverContainer = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverContainer.set(driver);
    }

    public static WebDriver getDriver() {
        return driverContainer.get();
    }

}
