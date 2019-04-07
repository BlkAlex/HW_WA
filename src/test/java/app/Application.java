package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.*;
import test.BrowsersFactory;
import test.MyListenerLogger;

import java.util.concurrent.TimeUnit;

/**
 * Created by blk
 */
public class Application {
    private WebDriver driver;
    public TinkoffJobPage tinkoffJob;
    public TinkoffTariffsPage tinkoffTariffs;
    public TinkoffDocumentsPage tinkoffDocumentsPage;
    public GoogleMainPage google;
    public GoogleResultPage googleResults;

    public MyListenerLogger getLogger() {
        return logger;
    }

    private MyListenerLogger logger;
    private final String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");

    public Application() {
        driver = new EventFiringWebDriver(getDriver());
        logger = new MyListenerLogger();
        ((EventFiringWebDriver) driver).register(logger);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        google = new GoogleMainPage(driver);
        googleResults = new GoogleResultPage(driver);
        tinkoffJob = new TinkoffJobPage(driver);
        tinkoffTariffs = new TinkoffTariffsPage(driver);
        tinkoffDocumentsPage = new TinkoffDocumentsPage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    private WebDriver getDriver() {
        return BrowsersFactory.buildDriver(browserName);
    }

}
