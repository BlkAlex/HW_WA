package test;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MyListenerLogger extends AbstractWebDriverEventListener {

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

    public void onNewStep(String name) {
        logger.info("Шаг : " + name);
    }
}
