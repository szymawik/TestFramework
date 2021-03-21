package configuration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class Screenshot {
    private WebDriver driver;
    private Logs log;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
        log = new Logs(this.getClass().getName());
    }

    public byte[] getScreenshot() {
        log.info("Takes Screenshot");
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    public void makeScreenshot(){
        log.info("Takes Screenshot");
        File fileScreen = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        try{
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH.mm.ss");
            String fileName = sdf.format(cal.getTime()) + ".png";
            String fileDirectory = "target/Downloads/";
            FileUtils.copyFile(fileScreen, new File(fileDirectory + fileName));
        } catch(java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
