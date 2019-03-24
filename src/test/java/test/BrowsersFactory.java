package test;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;


public class BrowsersFactory {
    private static final String PATH_TO_CHROME = "C:/webDriver/chromedriver.exe";
    private static final String PATH_TO_FIREFOX = "C:/webDriver/geckodriver.exe";
    private static final String PATH_TO_OPERA = "C:/webDriver/operadriver.exe";
    public static class MyListener extends AbstractWebDriverEventListener {

        Logger logger = LoggerFactory.getLogger(BrowsersFactory.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Обращение к элементу " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Найден элемент " + by);
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File file = new File("target", "sccreen-" + System.currentTimeMillis() + ".png");
            try {
                Files.copy(tmp, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.error(file.getAbsolutePath());
        }
    }

    public static WebDriver buildDriver(String browserName) throws MalformedURLException {
        switch (browserName) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                return new ChromeDriver(options);

            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty("webdriver.gecko.driver", PATH_TO_FIREFOX);
                FirefoxOptions ffOpt = new FirefoxOptions();
                ffOpt.addPreference("dom.webnotifications.enabled", false);
                return new FirefoxDriver(ffOpt);
            case "opera":
                System.setProperty("webdriver.opera.driver", PATH_TO_OPERA);
                return new OperaDriver();
            default:
                ChromeOptions options2 = new ChromeOptions();
                options2.addArguments("--disable-notifications");
                LoggingPreferences logPrefs2 = new LoggingPreferences();
                logPrefs2.enable(LogType.PERFORMANCE, Level.ALL);
                options2.setCapability(CapabilityType.LOGGING_PREFS, logPrefs2);
                return new ChromeDriver(options2);
        }
    }
}