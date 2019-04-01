package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    private final WebElement checkboxElement;

    public void click() {
        checkboxElement.click();
    }
    public boolean getState() {
        return checkboxElement.findElement(By.xpath(".//input")).getAttribute("checked") != null;
    }

    public CheckBox(WebDriver driver, String name) {
        checkboxElement = driver.findElement(By.xpath(Locators.getLocator("checkbox", name)));
    }
}
