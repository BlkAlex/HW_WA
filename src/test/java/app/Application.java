package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        System.setProperty("webdriver.chrome.driver", "C:/webDriver/chromedriver.exe");
        driver = new ChromeDriver();
       // baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//
//        driver = new EventFiringWebDriver(getDriver());
//        ((EventFiringWebDriver) driver).register(new test.BrowsersFactory.MyListener());
//        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //page
//        google = new GoogleMainPage(driver);
//        googleResults = new GoogleResultPage(driver);
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
