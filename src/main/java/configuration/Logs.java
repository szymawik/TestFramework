package configuration;

import cucumber.api.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class Logs {
    private Logger logger;

    public Logs(String className) {
        logger = LogManager.getLogger(className);
    }

    public void startScenario(Scenario scenario) {
        logger.info("******************************************************************************************************************************************************************");
        logger.info("************************************************************************* START SCENARIO *************************************************************************");
        logger.info("*" + scenario.getUri() + "*");
        logger.info("*" + scenario.getName() + "*");
        logger.info("******************************************************************************************************************************************************************");
        logger.info("******************************************************************************************************************************************************************");
    }

    public void endScenario() {
        logger.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX END SCENARIO XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        logger.info("X");
        logger.info("X");
        logger.info("X");
        logger.info("X");
    }

    public void info(String message) {
        logger.info(message);
    }

    public void info(String message, WebElement element) {
        logger.info(message + getSelectorFromElement(element));
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, WebElement element) {
        logger.error(message + getSelectorFromElement(element));
    }

    private String getSelectorFromElement(WebElement element) {
        String[] regex = element.toString().split("-> ");
        return " [" + regex[regex.length-1];
    }

}
