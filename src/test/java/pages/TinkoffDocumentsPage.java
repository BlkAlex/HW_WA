package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TinkoffDocumentsPage extends Page {
    public TinkoffDocumentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://www.tinkoff.ru/mobile-operator/documents/");
    }

    public void downloadAnyDocument(String name) {
        WebElement element = driver.findElement(By.xpath(String.format("//a[contains(@class,'Link')][contains(text(),'Первый месяц')]", name)));
        element.click();
        String[] splitStrings = element.getAttribute("href").split("/");
        waitForFile(driver, new File(String.format("externalFiles/downloadFiles/" + splitStrings[splitStrings.length - 1])), 5);

    }

    public void checkDownloadedFile() {
        File dir = new File("externalFiles/downloadFiles");
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        boolean isFileDownloaded = lst.size() > 0;
        for (File f : lst) {
            f.delete();
        }
        assertTrue(isFileDownloaded);

    }

    private void waitForFile(WebDriver driver, File file, long timeout) {
        FluentWait wait = new FluentWait(driver).withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
        wait.until((webDriver) -> file.exists());
    }
}
