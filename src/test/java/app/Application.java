package app;

import org.openqa.selenium.WebDriver;
import pages.GoogleMainPage;
import pages.GoogleResultPage;
import pages.TinkoffJobPage;
import pages.TinkoffTariffsPage;
import test.BrowsersFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by blk
 */
public class Application {
    private WebDriver driver;
    public TinkoffJobPage tinkoffJob;
    public TinkoffTariffsPage tinkoffTariffs;
    public GoogleMainPage google;
    public GoogleResultPage googleResults;

    public final String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");

    public Application() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        google = new GoogleMainPage(driver);
        googleResults = new GoogleResultPage(driver);
        //tinkoffJob = new TinkoffJobPage(driver);
        tinkoffTariffs = new TinkoffTariffsPage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    private WebDriver getDriver() {
        return BrowsersFactory.buildDriver(browserName);
    }

}
