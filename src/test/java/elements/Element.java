package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {
    WebElement webElement;

    Element(WebDriver driver, String type, String name) {
        webElement = driver.findElement(By.xpath(Locators.getLocator(type, name)));
    }

    public void click() {
        webElement.click();
    }

    public String getErrorMessage() {
        return webElement.findElement(By.xpath("./ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText();
    }
}
