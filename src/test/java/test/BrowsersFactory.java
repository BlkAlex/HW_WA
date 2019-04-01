package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.util.HashMap;


public class BrowsersFactory {

    public static WebDriver buildDriver(String browserName) {
        switch (browserName) {
            case "firefox":
                FirefoxOptions ffOpt = new FirefoxOptions();
                ffOpt.addPreference("dom.webnotifications.enabled", false);
                return new FirefoxDriver(ffOpt);
            case "opera":
                return new OperaDriver();
            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");

                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("download.default_directory",
                        System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
                chromePrefs.put("plugins.always_open_pdf_externally", true);
                options.setExperimentalOption("prefs", chromePrefs);
                return new ChromeDriver(options);
        }
    }
}