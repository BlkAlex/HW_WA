package app;

import org.openqa.selenium.WebDriver;
import pages.TinkoffJobPage;
import test.BrowsersFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Иван on 16.04.2018.
 */
public class Application {
    private WebDriver driver;
    public TinkoffJobPage tinkoffJob;
    public final String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");

    public Application() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        tinkoffJob = new TinkoffJobPage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    private WebDriver getDriver() {
        return BrowsersFactory.buildDriver(browserName);
    }

}
