package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    private final WebElement buttonElement;

    public Button(WebDriver driver, String name) {
        buttonElement = driver.findElement(By.xpath(Locators.getLocator("button", name)));
    }

    public boolean isActive() {
        return buttonElement.isEnabled();
    }

}
