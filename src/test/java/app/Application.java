package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.TinkoffJobPage;
import test.BrowsersFactory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иван on 16.04.2018.
 */
public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);
    private WebDriverWait wait;
    private WebDriver driver;
    public TinkoffJobPage tinkoffJob;
    public final String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");


    public Application() throws MalformedURLException {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        tinkoffJob = new TinkoffJobPage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    private WebDriver getDriver() throws MalformedURLException {
        return BrowsersFactory.buildDriver(browserName);
    }

}
