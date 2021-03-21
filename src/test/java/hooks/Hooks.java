package hooks;

import configuration.Configuration;
import configuration.Logs;
import configuration.Screenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import providers.DriverContainer;
import providers.DriverProvider;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class Hooks {
    private WebDriver driver;
    private Configuration configuration = ConfigFactory.create(Configuration.class);
    private Logs log = new Logs(this.getClass().getName());

    @Before
    public void setUp(Scenario scenario) {
        log.startScenario(scenario);
        driver = new DriverProvider().getDriver();
        DriverContainer.setDriver(driver);
        driver.get(configuration.applicationAddress());
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            this.log.error("Scenario " + scenario.getName() + " is failed");
            Screenshot screenshot = new Screenshot(driver);
            scenario.embed(screenshot.getScreenshot(), "image/png");
            this.log.info(driver.getCurrentUrl());
        }
        driver.quit();
        log.endScenario();
    }
}
