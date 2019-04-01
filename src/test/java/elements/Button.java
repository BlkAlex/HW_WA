package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    WebElement buttonElement;

    public Button(WebDriver driver, String name) {
        buttonElement = driver.findElement(By.xpath(Locators.getLocator("button", name)));
    }

    public boolean isActive() {
        return buttonElement.isEnabled();
    }
    public String getText() {
        return buttonElement.getText();
    }

    public void click() {
        buttonElement.click();
    }
}
