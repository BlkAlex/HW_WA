package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
    WebElement buttonElement;

    public void Button(WebDriver driver, String locator) {
        buttonElement = driver.findElement(By.xpath(locator));
    }

    public String getText() {
        return buttonElement.getText();//fixme
    }

    public void click() {
        buttonElement.click();
    }
}
